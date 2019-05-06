package com.sedion.zhe.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.sedion.zhe.Service.UserLoginService;
import com.sedion.zhe.Service.Impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//import 用于导入包    这里的包是Map
//表示这是@Controller   spring会扫描并创建UserLoginController对象
@Controller
public class UserLoginController {
	
	
	
	@Autowired
	//自动注入对象
	UserLoginService userLoginService ;
	//= new UserLoginServiceImpl();
	
	
	
	/**
	 * 登录页面方法
	 * @param request
	 * @return
	 */
	//@RequestMapping    里面是前端路径
	
	//@RequestMapping(value = {"/", "/login"})  // http://localhost/springmvc-mybatis/login
	@RequestMapping("/")  //
	public String userLogin() {
		//热部署
		System.out.println("userLogin.************************到达某某页面");
		//如果返回string     代表前端页面ftl的页面文件名字
		return "userlogin";
	}
	
	/**
	 * 登录验证的方法
	 * @param useraccount
	 * @param userpsw
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logining", method=RequestMethod.POST)// RequestMethod路径的请求方式
	//不是 String和void 就要加上ResponseBody转义成json
	//服务器与服务器      前端与后端的沟通（交互）  都是用json和xml沟通
	@ResponseBody
	public  Map<String, Object> userLoginValidate(String useraccount,String userpsw, HttpSession session) {
		
		//useraccount账号
		//userpsw密码
		System.out.println("登录请求");
		Map<String, Object> json = userLoginService.userLogin(useraccount, userpsw);
		
		if (null != json.get("id")) {
			session.setAttribute("userId", json.get("id"));			
		}
			return json;
	}
	
	
	
}
