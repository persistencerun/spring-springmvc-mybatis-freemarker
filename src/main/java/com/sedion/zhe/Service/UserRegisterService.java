package com.sedion.zhe.Service;

import java.util.Map;

import com.sedion.zhe.bean.UserBean;

public interface UserRegisterService {
	Map<String, Object> registerService(UserBean userBean, String code, String validateCode, String verifyUserPsw);
}
