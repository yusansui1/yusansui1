package com.example.mobileshop.http.entity;

public class MemberEntity {
    public int member_id;
    public String uname;
    public String password;
    public String email;
    public int sex;
    public String mobile;
    public long regtime;
    public long lastlogin;
    public String image;
    public String memberAddresses;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
