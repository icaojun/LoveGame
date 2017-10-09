package com.news.love.enums;

/**
 * Created by Administrator on 2017/10/9.
 */
public enum TypeEnum {

    RPG("角色扮演",0),ACT("动作",1),AVG("冒险",2),STG("射击",3),
    FTG("格斗",4),SPG("体育",5),RAC("竞速",6),MUG("音乐",7),PUZ("益智",8);

    private String mainType; // 主分类

    private int index;

    private TypeEnum(String mainType,int index){
        this.mainType = mainType;
        this.index = index;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (TypeEnum c : TypeEnum.values()) {
            if (c.getIndex() == index) {
                return c.mainType;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.print(TypeEnum.getName(2));
    }
}
