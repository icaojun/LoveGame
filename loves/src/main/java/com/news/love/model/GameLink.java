package com.news.love.model;

/**
 * Created by Administrator on 2017/9/22.
 */
public class GameLink {

    private String id; // 主键

    private String urlFrom; // 来源

    private String url; // 链接

    private String title; // 标题

    private long time; // 获取时间

    private String name; // 游戏名

    private String mainType; // 主分类

    private String subType; // 子分类

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlFrom() {
        return urlFrom;
    }

    public void setUrlFrom(String urlFrom) {
        this.urlFrom = urlFrom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
