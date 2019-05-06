package com.sedion.zhe.dao;

import org.apache.ibatis.annotations.Param;

import com.sedion.zhe.bean.UserBean;

public interface userDao {
	
	/**
	 * 根据账号查询用户是否存在
	 * @param useraccount
	 * @return
	 */
	 UserBean getUser(String useraccount);
	 
	 
	 
	 
	 
	 UserBean getUserbyId(int userId);
	 void uploadHead(@Param(value = "userhead") String userhead, @Param(value = "userId") Integer userId);
	 int insertUser(UserBean userBean);
}
