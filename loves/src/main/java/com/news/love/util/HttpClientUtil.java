package com.news.love.util;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/9.
 */
public class HttpClientUtil {

    private static int statusCode = 200;
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");

    /************************************
     * 发起get请求
     * @param url 请求url
     * @return html
     ************************************/
    public static String get(String url) {
        String html = "";
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(30000).setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .setStaleConnectionCheckEnabled(true).build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig).build();

        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(url);
            httpget.setConfig(requestConfig);
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                System.out.println("response code : " + response.getStatusLine());
                statusCode = response.getStatusLine().getStatusCode();
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // charset处理
                    String charset = getContentCharSet(entity);
                    if (charset != null && charset.length() > 0) {
                        if (charset.equalsIgnoreCase("gb2312")) {
                            charset = "GBK";
                        }
                        html = EntityUtils.toString(entity, charset);
                    } else {
                        byte[] bytes = EntityUtils.toByteArray(entity);
                        String docData = new String(bytes, "UTF-8");
                        charset = getcharsetbydoc(docData);
                        if (charset.equalsIgnoreCase("gb2312")) {
                            charset = "GBK";
                        }
                        html = new String(bytes, charset);
                    }
                    System.out.println("charset:" + charset);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return html;
    }

    public static String getContentCharSet(HttpEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
        String charset = null;
        if (entity.getContentType() != null) {
            HeaderElement values[] = entity.getContentType().getElements();
            if (values.length > 0) {
                NameValuePair param = values[0].getParameterByName("charset");
                if (param != null) {
                    charset = param.getValue();
                }
            }
        }
        return charset;
    }

    /**
     * 默认编码utf -8 使用jsoup解析，取得meta里的chaset
     */
    public static String getcharsetbydoc(String str) {
        String charset = "";
        Document doc = Jsoup.parse(str);
        Element meta = doc.select(
                "meta[http-equiv=content-type], meta[charset]").first();
        if (meta != null) { // if not found, will keep utf-8 as best attempt
            String foundCharset = null;
            if (meta.hasAttr("http-equiv")) {
                foundCharset = getCharsetFromContentType(meta.attr("content"));
            }
            if (foundCharset == null && meta.hasAttr("charset")) {
                try {
                    if (Charset.isSupported(meta.attr("charset"))) {
                        foundCharset = meta.attr("charset");
                    }
                } catch (IllegalCharsetNameException e) {
                    foundCharset = null;
                }
            }

            if (foundCharset != null && foundCharset.length() != 0
                    && !foundCharset.equals("UTF-8")) { // need to re-decode
                foundCharset = foundCharset.trim().replaceAll("[\"']", "");
                charset = foundCharset;
                doc = null;
            }
        }

        if (StringUtils.isEmpty(charset)) {
            charset = "UTF-8";
        }
        return charset;
    }

    public static String getCharsetFromContentType(String contentType) {
        if (contentType == null)
            return null;
        Matcher m = charsetPattern.matcher(contentType);
        if (m.find()) {
            String charset = m.group(1).trim();
            charset = charset.replace("charset=", "");
            if (charset.length() == 0)
                return null;
            try {
                if (Charset.isSupported(charset))
                    return charset;
                charset = charset.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(charset))
                    return charset;
            } catch (IllegalCharsetNameException e) {
                // if our advanced charset matching fails.... we just take the
                // default
                return null;
            }
        }
        return null;
    }
}
