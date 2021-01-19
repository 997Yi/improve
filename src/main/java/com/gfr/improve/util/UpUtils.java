package com.gfr.improve.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class UpUtils {

    public static String upfile(MultipartFile file, HttpServletRequest request) {

        //上传到服务器 同时上传到本地
        /**1.获取文件名称
         * 2.判断当前文件类型并设置存放路径
         * 3.判断存放路径是否存在，如不存在则自动创建
         * 4.创建文件输出流
         * 5.调用write函数通过二进制的方式将内容写入对应文件中
         * 6。刷新缓存
         * 7.关闭流
         * 8.返回文件路径
         */
        //获取当前文件的名称
        String originalFilename = file.getOriginalFilename();
        //判断当前文件是什么类型
        String realPath = "";
        String localPath = null;
        try {
            localPath = new File("").getCanonicalPath()+"\\src\\main\\resources\\static\\";
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "http://localhost:8080/";

        if (originalFilename.endsWith(".mp4")) {
            realPath = request.getSession().getServletContext().getRealPath("/video/");
            localPath += "video\\";
            s=s+"video/";
        } else if (originalFilename.endsWith(".jpg") || originalFilename.endsWith(".png") || originalFilename.endsWith(".jpeg")) {
            realPath = request.getSession().getServletContext().getRealPath("/img/");
            localPath += "img\\";
            s=s+"img/";
        } else if (originalFilename.endsWith(".mp3")) {
            realPath = request.getSession().getServletContext().getRealPath("/audio/");
            localPath += "audio\\";
            s=s+"audio/";
        }
        //创建服务器文件对象
        File file1 = new File(realPath);
        //判定当前文件是否存在，不存在则创建
        if (!file1.exists()) {
            file1.mkdirs();
        }

        //创建本地服务器文件对象
        File file2 = new File(localPath);
        //判定当前文件是否存在，不存在则创建
        if (!file2.exists()) {
            file2.mkdirs();
        }

        FileOutputStream fos = null;
        FileOutputStream fos1 = null;
        try {
            //http://localhost:8080/img/a.mp4
            // true 表示文件追加   如果为false  则文件夹中永远只有一个文件(最后上传的)
            fos = new FileOutputStream(realPath + originalFilename, true);
            fos.write(file.getBytes());
            fos.flush();

            fos1 = new FileOutputStream(localPath + originalFilename, true);
            fos1.write(file.getBytes());
            fos1.flush();


//            TODO 为什么不可以返回服务器中保存图片的路径？
            return s+originalFilename;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } finally {
            try {
                fos.close();

                fos1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
