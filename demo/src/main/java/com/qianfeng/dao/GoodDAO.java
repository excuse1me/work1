package com.qianfeng.dao;

import com.qianfeng.entity.Good;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@MapperScan
public interface GoodDAO {
    List<Good> findAll();
    Good findById(String goodId);
    void insert(Good good);
    List<Good> queryGoodByPage(@Param("index") Integer index, @Param("size") Integer size);
}
