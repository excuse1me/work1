package com.qianfeng.util;

import com.qianfeng.entity.Good;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
public class FileId {
    public Good fileId(Good good, MultipartFile file , MultipartFile file1 , MultipartFile file2)
            throws Exception{
        String s = UUID.randomUUID().toString().replaceAll("-","");
        file.transferTo(new File(Allocation.PATH + s));
        String s1 = UUID.randomUUID().toString().replaceAll("-","");
        file.transferTo(new File(Allocation.PATH + s1));
        String s2 = UUID.randomUUID().toString().replaceAll("-","");
        file.transferTo(new File(Allocation.PATH + s2));
        good.setGoodPic(s);
        good.setGoodPic1(s1);
        good.setGoodPic2(s2);
        return good;
    }
}
