package com.sedion.zhe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sedion.zhe.bean.BBSMessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sedion.zhe.Service.UserIndexService;
import com.sedion.zhe.Service.UserLoginService;
import com.sedion.zhe.bean.PageBean;
import com.sedion.zhe.bean.UserBean;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private UserIndexService userIndexService;
	
	
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/")
	public String getIndex(){
		System.out.println("IndexController  首页******************************");
		return "redirect:/index/1";
	}
	
	@RequestMapping({"/{currentPage}"})
	public ModelAndView index(HttpSession session, @ModelAttribute("currentPage")int currentPage) {
		Map<String,Object> map = new HashMap<String, Object>();
		int userId = (Integer) session.getAttribute("userId");
		UserBean bean = userLoginService.getUserbyId(userId);
		PageBean pageBean = userIndexService.pagination(currentPage, 10);
		map.put("user", bean);
		map.put("pageBean", pageBean);
		ModelAndView modelAndView = new ModelAndView("index", map);
		return modelAndView;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/changeImg")
	public String changeImg(HttpSession session, HttpServletRequest request) {
		int userId = (Integer) session.getAttribute("userId");
		UserBean bean = userLoginService.getUserbyId(userId);
		request.setAttribute("user", bean);
		return "changeImg";
	}

	@RequestMapping(value = "/changeImg/changing", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> changing(@RequestParam("uploadhead") MultipartFile userhead,
			HttpServletRequest request) throws IOException {
		Map<String, Object> res;
		res = userIndexService.changImg(userhead, (Integer) request.getSession().getAttribute("userId"));
		return res;
	}
	@RequestMapping(value = "/changeBBS/{number}")
	public ModelAndView changeBbs(@PathVariable("number") int bbsId, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("changeBBS");
		BBSMessageBean bbsMessageBean = userIndexService.getBBS(bbsId);
		request.getSession().setAttribute("bbsId", bbsId);
		modelAndView.getModel().put("bbs", bbsMessageBean);
		return modelAndView;
	}
	@RequestMapping(value = "/changeBBS/save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveBBS(@ModelAttribute BBSMessageBean bbsMessageBean, 
			@RequestParam("bbsTitle") String bbsTitle,
			HttpServletRequest request){
		bbsMessageBean.setUserId((Integer) request.getSession().getAttribute("bbsId"));
		bbsMessageBean.setBbsTile(bbsTitle);
		Map<String, Object> res = userIndexService.updateBBS(bbsMessageBean);
		return res;
	}
	
}
