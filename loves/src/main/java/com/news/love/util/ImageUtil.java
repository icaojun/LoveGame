package com.news.love.util;

/**
 * Created by Administrator on 2017/9/25.
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 图片下载,链接生成
 */
public class ImageUtil {

    /*******************************************************
     *
     * @param url 网络图片地址
     * @return 图片二进制流
     *******************************************************/
    public static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url)
                    .openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                return inputStream;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*********************************************************************
     *
     * @param is 图片流
     * @param path 图片保存路径
     * @param name 图片名
     *********************************************************************/
    public static void saveData(InputStream is, String path ,String name) {
        try{
            File file = new File(path + name);
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = ImageUtil.getInputStreamByGet("http://img.xker.com/xkerfiles/allimg/1507/11034W241-0.jpg");
        saveData(inputStream,"G:/","2.png");
    }

}
