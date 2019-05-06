package com.sedion.zhe.dao;

import org.apache.ibatis.annotations.Param;

import com.sedion.zhe.bean.BBSMessageBean;

/**
 * Created by Mr.W on 16/6/24.
 */
public interface bbsDao {
    BBSMessageBean getBBSbyId(int bbsId);
    void updateBBS(@Param(value="bean") BBSMessageBean bean);
}
