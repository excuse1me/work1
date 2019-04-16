package com.qianfeng.controller;

import com.qianfeng.entity.Memeber;
import com.qianfeng.exception.PasswordErrorException;
import com.qianfeng.exception.UsernameNotFoundException;
import com.qianfeng.service.MemeberServiceImp;
import com.qianfeng.vo.JsonResultVO;
import com.qianfeng.vo.LoginInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/memeber")//根目录
public class MemeberController {

    @Resource
    private MemeberServiceImp memeberServiceImp;

   /* @PostMapping("/login")
    public String login(LoginInfoVO loginInfoVO , HttpSession session){
        try{
            Memeber memeber = memeberServiceImp.login(loginInfoVO);
            session.setAttribute("memeber",memeber);
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/login.jsp";
        }
        return "redirect:/hello.jsp";
    }*/

    @ResponseBody
    @PostMapping("/login2")
    public JsonResultVO loginAjax(LoginInfoVO loginInfoVO ,HttpSession session) {
        JsonResultVO jsonResultVO = new JsonResultVO();
        try{
            Memeber memeber = memeberServiceImp.login(loginInfoVO);
            session.setAttribute("memeber",memeber);
            jsonResultVO.setCode(1);
        }catch (NullPointerException e){
            e.printStackTrace();
//            return "{code:0,msg:'请输入用户名'}";
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("请输入用户名");
        }catch (PasswordErrorException|UsernameNotFoundException e1){
            e1.printStackTrace();
//            return "{code:0,msg:'用户名或者密码错误'}";
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("用户名或者密码错误");
        }catch (Exception e3){
            e3.printStackTrace();
//            return "{code:0,msg:'请联系管理员!'}";
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("请联系管理员");
        }
        /*重定向不会经过视图解析器*/
        //{code:1,msg:'登录成功'}，code是用来进行条件判断的，msg用来显示
        return jsonResultVO;
    }
}
