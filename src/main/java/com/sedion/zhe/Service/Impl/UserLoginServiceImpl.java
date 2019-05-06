package com.sedion.zhe.Service.Impl;

import java.util.HashMap;
import java.util.Map;

import com.sedion.zhe.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sedion.zhe.bean.UserBean;
import com.sedion.zhe.dao.userDao;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private userDao userDao;
	
	
	/**
	 * 构造器（给你说什么时候spring给你创建好了这个对象）
	 */
	public UserLoginServiceImpl() {
		System.out.println("spring创建这个对象***************************");
	}

	/**
	 * 用户登录
	 */
	public Map<String, Object> userLogin(String useraccount, String userpsw) {
		System.out.println("浏览器输入账号："+useraccount+"浏览器输入密码："+userpsw);
		
		
		//多态
		Map<String, Object> map = new HashMap<String, Object>();
		
		//根据账号查询用户是否存在
		UserBean userBean = userDao.getUser(useraccount);
		
		System.out.println("查询出来的用户："+userBean);
		
		
		if (null == userBean) {
			//数据库不存在这个用户
			map.put("res", 59);
			return map;
		} else if (!userBean.getUserpsw().equals(userpsw)) {
			//密码正确
			//查询出来的用户密码和浏览器输入密码是否一致
			map.put("res", 60);
			return map;
		} else {
            //密码不正确
			int id = userBean.getId();
			map.put("res", 100);
			map.put("id", id);
			map.put("bean", userBean);
			return map;
		}
	}
	
	public UserBean getUserbyId(int userId) {
		UserBean user = userDao.getUserbyId(userId);
		return user;
	}

}
