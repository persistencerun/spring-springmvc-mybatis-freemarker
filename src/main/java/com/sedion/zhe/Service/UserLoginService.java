package com.sedion.zhe.Service;

import java.util.Map;

import com.sedion.zhe.bean.UserBean;

public interface UserLoginService {
	/**
	 * 用户登录
	 * @param userAccount
	 * @param userPsw
	 * @return
	 */
	Map<String, Object> userLogin(String userAccount, String userPsw) ;
	
	
	
	
	
	
	UserBean getUserbyId(int userId);
}
