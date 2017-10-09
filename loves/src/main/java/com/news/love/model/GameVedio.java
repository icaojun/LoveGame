package com.news.love.model;

/**
 * Created by Administrator on 2017/10/9.
 */

/**
 * 视频信息
 */
public class GameVedio {

    private String id; // 主键

    private String pageId; // 新闻ID

    private String vedioUrlb; // 视频原始链接

    private String suffix; // 视频后缀

    private String vedioUrla; // 视频生成链接

    private int width; // 视频宽度

    private int height; // 视频高度

    private int size; // 视频大小

    private long length; // 视频时长

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getVedioUrlb() {
        return vedioUrlb;
    }

    public void setVedioUrlb(String vedioUrlb) {
        this.vedioUrlb = vedioUrlb;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getVedioUrla() {
        return vedioUrla;
    }

    public void setVedioUrla(String vedioUrla) {
        this.vedioUrla = vedioUrla;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}
