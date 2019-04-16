package com.qianfeng.service;

import com.qianfeng.entity.Good;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodService {
    List<Good> findAll();
    Good findById(String goodId);
    String insert(Good good , MultipartFile file ,MultipartFile file1 ,MultipartFile file2);
    Integer divide();
    Integer start(Integer index);
    List<Good> paging(Integer index);
}
