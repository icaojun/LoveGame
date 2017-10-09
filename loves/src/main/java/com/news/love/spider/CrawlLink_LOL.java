package com.news.love.spider;

import com.news.love.model.GameLink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/9.
 */
public class CrawlLink_LOL {

    private static List<String> list = new ArrayList<String>();


    public static List<GameLink> getLinks(String urlfrom){
        return null;
    }




    public static void main(String[] args) {
        List<GameLink> list = getLinks("");
        for(GameLink link : list){
            System.out.println(link.toString());
        }
    }
}
