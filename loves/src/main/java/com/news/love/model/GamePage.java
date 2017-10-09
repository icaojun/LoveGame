package com.news.love.model;

/**
 * Created by yjc on 2017/9/22.
 */

import java.util.Date;
import java.util.List;

/**
 * 游戏新闻类
 */
public class GamePage {

    private String id; // 主键

    private String urlb; // 原始链接

    private String urla; // 生成链接

    private String urlFrom; // 来源

    private String title; //标题

    private Date pubishTime; // 发布时间

    private long time; // 获取时间

    private String source; // 内容来源

    private String author; // 作者

    private String content; // 正文

    private String mainType; // 主分类

    private String subType; // 子分类

    private String keywords; //关键字

    private String html; // html内容

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlb() {
        return urlb;
    }

    public void setUrlb(String urlb) {
        this.urlb = urlb;
    }

    public String getUrla() {
        return urla;
    }

    public void setUrla(String urla) {
        this.urla = urla;
    }

    public String getUrlFrom() {
        return urlFrom;
    }

    public void setUrlFrom(String urlFrom) {
        this.urlFrom = urlFrom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubishTime() {
        return pubishTime;
    }

    public void setPubishTime(Date pubishTime) {
        this.pubishTime = pubishTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

}
