package com.qianfeng.service;

import com.qianfeng.dao.MemeberDAO;
import com.qianfeng.entity.Memeber;
import com.qianfeng.exception.PasswordErrorException;
import com.qianfeng.exception.UsernameNotFoundException;
import com.qianfeng.util.MD5Utils;
import com.qianfeng.vo.LoginInfoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemeberServiceImp {

    @Resource
    private MemeberDAO memeberDAO;

    public Memeber login(LoginInfoVO loginInfoVO) throws Exception {
        if(loginInfoVO == null){
            throw new NullPointerException("param is null");
        }
        String username = loginInfoVO.getUsername();
        String password = loginInfoVO.getPassword();
        if(null == username || "".equals(username)){
            throw new NullPointerException("username is null");
        }

        //1、检验用户名在数据库是否存在
        Memeber memeber = memeberDAO.checkUsername(username);
        if(memeber == null){
            try {
                throw new UsernameNotFoundException();
            } catch (UsernameNotFoundException e) {
                e.printStackTrace();
            }
        }

        //2、密码校验
        //a、先对用户传入的密码进行加密
        String passwordSalt = memeber.getPasswordSalt();
        String md5password = MD5Utils.md5(password,passwordSalt);
        //b、同数据库的密文进行对比
        if(!md5password.equals(memeber.getPassword())){
            try {
                throw  new PasswordErrorException("password is error");
            } catch (PasswordErrorException e) {
                e.printStackTrace();
            }
        }
        return memeber;
    }
}
