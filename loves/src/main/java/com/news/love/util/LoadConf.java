package com.news.love.util;

/**
 * Created by Administrator on 2017/10/9.
 */

import com.news.love.constant.Constant;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件信息
 */
public class LoadConf {

    public static String getValue(String key){
        Properties prop =  new  Properties();
        String value = "";
        try  {
            InputStream in = new BufferedInputStream(new FileInputStream((Constant.configPath)));
            prop.load(in);
            value = prop.getProperty(key).trim();
        }  catch  (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.print(LoadConf.getValue("ipConfig"));
    }
}
