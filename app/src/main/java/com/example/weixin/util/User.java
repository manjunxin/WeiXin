package com.example.weixin.util;

public class User {
     int img;
     String username;
     String pinyin;
     String firstLetter;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public User() {
    }

    public User(int img, String username, String pinyin, String firstLetter) {
        this.img = img;
        this.username = username;
        this.pinyin = pinyin;
        this.firstLetter = firstLetter;
    }
}
