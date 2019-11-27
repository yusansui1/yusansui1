package com.example.mobileshop.http.entity;

import java.io.Serializable;

public class GoodsEntity implements Serializable {
    private int good_id;
    private String name;
    private double price;
    private String mktprice;
    private String small;
    private int mkt_enable;
    private String briefGoodsCat;
    private String briefBrand;

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMktprice() {
        return mktprice;
    }

    public void setMktprice(String mktprice) {
        this.mktprice = mktprice;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public int getMkt_enable() {
        return mkt_enable;
    }

    public void setMkt_enable(int mkt_enable) {
        this.mkt_enable = mkt_enable;
    }

    public String getBriefGoodsCat() {
        return briefGoodsCat;
    }

    public void setBriefGoodsCat(String briefGoodsCat) {
        this.briefGoodsCat = briefGoodsCat;
    }

    public String getBriefBrand() {
        return briefBrand;
    }

    public void setBriefBrand(String briefBrand) {
        this.briefBrand = briefBrand;
    }
}
