package com.qianfeng.dao;

import com.qianfeng.entity.Memeber;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@MapperScan
@Repository
public interface MemeberDAO {
    Memeber checkUsername(@Param("username") String username);
}
