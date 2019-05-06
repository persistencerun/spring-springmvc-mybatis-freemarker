package com.sedion.zhe.bean;

import org.springframework.stereotype.Repository;


@Repository
public class BBSMessageBean {
	private String userAccount;
	private String userBBS;
	private String bbsTitle;
	private String data;
	private int bbsId;
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserBBS() {
		return userBBS;
	}
	public void setUserBBS(String userBBS) {
		this.userBBS = userBBS;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTile(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getUserId() {
		return bbsId;
	}
	public void setUserId(int userId) {
		this.bbsId = userId;
	}
}
