package com.sedion.zhe.Service;

import java.io.IOException;
import java.util.Map;

import com.sedion.zhe.bean.BBSMessageBean;
import org.springframework.web.multipart.MultipartFile;

import com.sedion.zhe.bean.PageBean;

public interface UserIndexService {
	Map<String, Object> changImg(MultipartFile userHead, int userId) throws IOException;
	PageBean pagination(int currentPage, int pageSize);
	BBSMessageBean getBBS(int userId);
	Map<String, Object> updateBBS(BBSMessageBean bbsMessageBean);
	} 
