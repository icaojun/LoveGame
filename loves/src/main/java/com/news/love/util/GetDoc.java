package com.news.love.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Administrator on 2017/10/9.
 */
public class GetDoc {

    public static Document getdoc(String url, int timeout, int waittime, int retrytime) {
        Document doc = null;
        for (int i = 0; i < retrytime; i++) {
            try {
                // 如果2次连接间隔不为0,则等待
                if (waittime > 0) {
                    Thread.sleep(waittime);
                }
                String html = HttpClientUtil.get(url);
                doc = Jsoup.parse(html);
                if (doc != null) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doc;
    }

    public static void main(String[] args) {
        Document document = GetDoc.getdoc("https://www.baidu.com/",3000,0,2);
        System.out.print(document.text());
    }
}
