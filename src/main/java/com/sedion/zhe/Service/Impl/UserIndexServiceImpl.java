package com.sedion.zhe.Service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sedion.zhe.bean.BBSMessageBean;
import com.sedion.zhe.bean.PageBean;
import com.sedion.zhe.dao.pageDao;
import com.sedion.zhe.dao.userDao;
import com.sedion.zhe.dao.bbsDao;
import com.sedion.zhe.Service.UserIndexService;

@Service
public class UserIndexServiceImpl implements UserIndexService {

    @Autowired
    public userDao userDao;
    @Autowired
    public pageDao pageDao;
    @Autowired
    public bbsDao bbsDao;

    public Map<String, Object> changImg(MultipartFile userhead, int userId) throws IOException {
        String contentType = userhead.getContentType();
        Map<String, Object> json = new HashMap<String, Object>();
        if (!contentType.contains("image/")) {
            json.put("res", 59);
            return json;
        } else if (userhead.getSize() > 409600) {
            json.put("res", 60);
            return json;
        } else {
            String fileName = System.nanoTime() + "";
            String tempFileName = userhead.getOriginalFilename();
            String[] fileSuffix = tempFileName.split("\\.");
            File newHead = new File("/Users/x72/Documents/tomcatw/springmvc-mybatis/headimage/" + fileName + "." + fileSuffix[fileSuffix.length - 1]);
            File newHead2 = new File("/Users/x72/Documents/workspace/springmvc-mybatis/headimage/" + fileName + "." + fileSuffix[fileSuffix.length - 1]);
            fileName += "." + fileSuffix[fileSuffix.length - 1];
            fileName = "/headimage/" + fileName;

            //保存新头像
            FileUtils.copyInputStreamToFile(userhead.getInputStream(), newHead);
            FileUtils.copyInputStreamToFile(userhead.getInputStream(), newHead2);

            //删除原头像
            String oldName = userDao.getUserbyId(userId).getUserhead();
            File file = new File("/Users/x72/Documents/tomcatw/springmvc-mybatis" + oldName);
            File file2 = new File("/Users/x72/workspace/tomcatw/springmvc-mybatis" + oldName);
            if (file.exists()) {
                file.delete();
                file2.delete();
            }
            userDao.uploadHead(fileName, userId);
            json.put("res", 100);
            json.put("userhead", fileName);
            return json;
        }
    }

    public PageBean pagination(int currentPage, int pageSize) {
        // TODO Auto-generated method stub
        int totalRow = pageDao.getTotalRow();
        PageBean pageBean = new PageBean();
        pageBean.setTotalRow(totalRow);
        pageBean.setPageSize(pageSize);
        pageBean.setPageNumber(currentPage);
        List<BBSMessageBean> res = pageDao.getPageMessage(currentPage, pageSize);
        pageBean.setList(res);
        return pageBean;
    }

    public BBSMessageBean getBBS(int bbsId) {
        BBSMessageBean bbsMessageBean = bbsDao.getBBSbyId(bbsId);
        return bbsMessageBean;
    }

    public Map<String, Object> updateBBS(BBSMessageBean bbsMessageBean) {
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            bbsDao.updateBBS(bbsMessageBean);
            res.put("res", 100);
        }catch (Exception e) {
            res.put("res","fail");
        }
        return  res;
    }

}