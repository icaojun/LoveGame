package com.news.love.util;

/**
 * Created by Administrator on 2017/10/9.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.news.love.constant.Constant;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * 根据IP地址获取地理位置
 */
public class AddressUtil {

    /***********************************************************
     * 获取登录用户的IP地址
     *
     * @param request
     * @return
     ***********************************************************/
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    /*******************************************
     * 通过IP获取地址(需要联网，调用淘宝的IP库)
     *
     * @param ip
     * @return
     *******************************************/
    public static String getIpInfo(String ip) {
        if (ip.equals("本地")) {
            ip = "127.0.0.1";
        }
        String info = "";
        try {
            String ipAddress = LoadConf.getValue("ipConfig");
            URL url = new URL(ipAddress + ip);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            InputStream in = conn.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            StringBuffer temp = new StringBuffer();
            String line = bufferedReader.readLine();
            while (line != null) {
                temp.append(line).append("\r\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            JSONObject obj = (JSONObject) JSON.parse(temp.toString());
            if (obj.getIntValue("code") == 0) {
                JSONObject data = obj.getJSONObject("data");
                info += data.getString("country") + " ";
                info += data.getString("region") + " ";
                info += data.getString("city") + " ";
                info += data.getString("isp");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public static void main(String[] args) {
        System.out.print(AddressUtil.getIpInfo("140.207.49.76"));
    }

}
