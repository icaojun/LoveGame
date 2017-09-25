package com.news.love.model;

/**
 * Created by yjc on 2017/9/22.
 */

/**
 * 图片信息
 */
public class GameImage {

    private String id; // 主键id

    private String pageId; // 新闻ID

    private String imageUrlb; // 图片原始链接

    private String suffix; // 图片后缀

    private String imageUrla; // 图片生成链接

    private int width; // 图片宽度

    private int height; // 图片高度

    private int size; // 图片大小

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

    public String getImageUrlb() {
        return imageUrlb;
    }

    public void setImageUrlb(String imageUrlb) {
        this.imageUrlb = imageUrlb;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getImageUrla() {
        return imageUrla;
    }

    public void setImageUrla(String imageUrla) {
        this.imageUrla = imageUrla;
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
}
