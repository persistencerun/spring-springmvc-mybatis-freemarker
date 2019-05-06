package com.sedion.zhe.bean;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class UserBean implements Serializable{
	//用户账号
	private String userAccount;
	//用户性别
	private String userSex;
	//用户生日
	private String userBirth;
	//用户密码
	private String userpsw;
	//
	private int id;
	//用户头像
	private String userhead;
	//用户邮箱
	private String userEmail;
	
	
	
	
	
	
	
	
	
	
	
	public String getUserhead() {
		return userhead;
	}

	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserpsw() {
		return userpsw;
	}

	public void setUserpsw(String userpsw) {
		this.userpsw = userpsw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
	
	
	@Override
	public String toString() {
		return "用户属性toString [userAccount=" + userAccount + ", userSex=" + userSex + ", userBirth=" + userBirth
				+ ", userpsw=" + userpsw + ", id=" + id + ", userhead=" + userhead + ", userEmail=" + userEmail + "]";
	}

	
}
