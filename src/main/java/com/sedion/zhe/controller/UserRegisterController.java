package com.sedion.zhe.controller;

import java.awt.image.BufferedImage;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.sedion.zhe.Service.Impl.UserRegisterServiceImpl;
import com.sedion.zhe.bean.UserBean;

@Controller
@Scope("request")
@RequestMapping("/register")
public class UserRegisterController {

	@Autowired
	private Producer captchaProducer = null;

	@Autowired
	private UserRegisterServiceImpl userRegisterService;
	
	
	
	@RequestMapping(value = { "/", "" })
	public String register() {
		System.out.println("UserRegisterController   跳转到注册页面**********");
		return "userregister";
	}

	
	
	
	@RequestMapping(value = "/registerResult", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> registerResult(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute UserBean userBean, 
			@RequestParam("birthDay") String birthDay,
			@RequestParam("birthMonth") String birthMonth, 
			@RequestParam("birthYear") String birthYear, 
			@RequestParam("safecode") String valdateCode, 
			@RequestParam("verifyuserpsw") String verifyUserpsw) {
		
		
		System.out.println("注册添加****************************");
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.println("code:"+code);
		
		userBean.setUserBirth(birthYear + "/" + birthMonth + "/" + birthDay);
		userBean.setUserhead("/headimage/de.jpg");
		
		
		Map<String, Object> res = userRegisterService.registerService(userBean, code, valdateCode, verifyUserpsw); 
		
		System.out.println("注册后返回参数："+res);
		if (null != res.get("userId")) {
			session.setAttribute("userId", res.get("userId"));
			return res;
		}else {
		    return res;
		}
	}
	
	
	
	
	
	

	@RequestMapping(value = "/kaptcha")
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("验证码：kaptcha");
		
		HttpSession session = request.getSession();

		response.setDateHeader("Expires", 0);

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		// return a jpeg
		response.setContentType("image/jpeg");

		// create the text for the image
		String capText = captchaProducer.createText();

		// store the text in the session
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

		// create the image with the text
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();

		// write the data out
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}
}
