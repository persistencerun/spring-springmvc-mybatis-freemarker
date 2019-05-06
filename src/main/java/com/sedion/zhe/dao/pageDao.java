package com.sedion.zhe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sedion.zhe.bean.BBSMessageBean;

public interface pageDao {
	
	 int getTotalRow();
	 List<BBSMessageBean> getPageMessage(@Param(value="currentPage")int currentPage, @Param(value="pageSize")int pageSize);
}
