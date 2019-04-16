package com.qianfeng.controller;

import com.qianfeng.entity.Good;
import com.qianfeng.service.GoodService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Resource
    private GoodService goodService;

    @RequestMapping("/findAll")
    public Integer findAll(){
        return goodService.findAll().size();
    }

    @RequestMapping("/paging")
    public List<Good> paging(Integer index){
        return goodService.paging(index);
    }

    @RequestMapping("/pagination")
    public Integer pagination(){
        return goodService.divide();
    }

    @RequestMapping("/insert")
    public String insert(Good good , MultipartFile file,MultipartFile file1,MultipartFile file2){
        return goodService.insert(good,file,file1,file2);
    }

    @PostMapping("/findById")
    public Good findById(String goodId){
        return goodService.findById(goodId);
    }
}
