package com.windshadow.tools;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传类
 */

@Component
public class FileNameUtils {

    public static List<String> filejiexi( List<MultipartFile> fileG,String icok) throws UnsupportedEncodingException {
        List<String> picture = new ArrayList<String>();
        for (int i = 0; i < fileG.size(); i++) {
            if (!fileG.get(i).isEmpty()) {
                String olFileName = fileG.get(i).getOriginalFilename();//原文件名
                String fileName = System.currentTimeMillis() + olFileName;//新的文件名
                File targetFile = new File(route(icok), fileName);
                try {
                    fileG.get(i).transferTo(targetFile); //文件上传
                    String ol = "images\\"+icok+"\\"+fileName;
                    ol = ol.replaceAll("\\\\","/");
                    picture.add(ol);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return picture;
    }

    //获取存储图片的路径
    public static  String route(String icok) throws UnsupportedEncodingException {
        String jj= Class.class.getClass().getResource("/").getPath();//获取当前文件目录
        jj=java.net.URLDecoder.decode(jj, "utf-8");//中文乱码转换
        // G:\项目\owKen\windshadow\web\src\main\resources\static\images
        String[] ku = jj.split("windshadow");
        int p=ku[0].length();
        String jq = jj.substring(1,p);
        return jq+"windshadow\\web\\src\\main\\resources\\static\\images\\"+icok;//获取到存放图片的目录;
    }
}
