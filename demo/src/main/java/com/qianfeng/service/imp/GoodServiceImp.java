package com.qianfeng.service.imp;

import com.qianfeng.dao.GoodDAO;
import com.qianfeng.entity.Good;
import com.qianfeng.service.GoodService;
import com.qianfeng.util.Allocation;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class GoodServiceImp implements GoodService {
    @Resource
    private GoodDAO goodDAO;

    //查询所有
    public List<Good> findAll(){
        return goodDAO.findAll();
    }

    public Good findById(String goodId){
        return goodDAO.findById(goodId);
    }

    @Override
    public String insert(Good good, MultipartFile file, MultipartFile file1, MultipartFile file2) {
            try {
                if(file != null){
                    String s = UUID.randomUUID().toString().replaceAll("-","");
                    good.setGoodPic(s);
                    file.transferTo(new File(Allocation.PATH + s));
                }
                if(file1 != null){
                    String s1 = UUID.randomUUID().toString().replaceAll("-","");
                    good.setGoodPic(s1);
                    file.transferTo(new File(Allocation.PATH + s1));
                }
                if(file2 != null){
                    String s2 = UUID.randomUUID().toString().replaceAll("-","");
                    good.setGoodPic(s2);
                    file.transferTo(new File(Allocation.PATH + s2));
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("图片添加失败");
                return "0";
            }
            good.setCreateTime(new Date());
            String[] goodId = UUID.randomUUID().toString().split("-");
            good.setGoodId(goodId[0]);
            goodDAO.insert(good);
            return "1";
        }

    //商品信息全表查询分页页数
    public Integer divide(){
        Integer size = findAll().size();
        Integer page = null;
        if(size % Allocation.PAGE_SIZE == 0){
            page = size/Allocation.PAGE_SIZE;
        }else {
            page=size/Allocation.PAGE_SIZE;
        }
        return page;
    }

    //分页起始数
    public Integer start(Integer index){
        return (index-1)*Allocation.PAGE_SIZE;
    }

    //分页显示
    public List<Good> paging(Integer index){
        if(index != null){
            Integer start = start(index);
            return null;
        }
        return null;
    }
}
