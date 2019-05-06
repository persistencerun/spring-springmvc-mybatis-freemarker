package com.sedion.zhe.Service.Impl;

import java.util.HashMap;
import java.util.Map;

import com.sedion.zhe.Service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sedion.zhe.bean.UserBean;
import com.sedion.zhe.dao.userDao;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	@Autowired
	private userDao userDao;

	public Map<String, Object> registerService(UserBean userBean, String code, String validateCode,
			String verifyUserPsw) {
		
		Map<String, Object> res = new HashMap<String, Object>();
		
		if (6 > userBean.getUserAccount().trim().length()) {
			res.put("res", 1);
			return res;
		} else if (6 > userBean.getUserpsw().trim().length()) {
			res.put("res", 2);
			return res;
		} else if (!userBean.getUserpsw().equals(verifyUserPsw)) {
			res.put("res", 3);
			return res;
		} else if (!code.equalsIgnoreCase(validateCode)) {
			res.put("res", 4);
			return res;
		} else if (null != userDao.getUser(userBean.getUserAccount())) {
			res.put("res", 5);
			return res;
		} else {
			userDao.insertUser(userBean);
			userBean = userDao.getUser(userBean.getUserAccount());
			res.put("res", 100);
			res.put("userId", userBean.getId());
			return res;
		}
	}

}
