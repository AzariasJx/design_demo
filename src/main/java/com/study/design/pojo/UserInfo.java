package com.study.design.pojo;

import java.util.List;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 21:54
 */
public class UserInfo {

    private String username;
    private String city;
    //最近购买商品
    private List<String> buyProducts;

    //是否是新用户
    private boolean isNewUser;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getBuyProducts() {
        return buyProducts;
    }

    public void setBuyProducts(List<String> buyProducts) {
        this.buyProducts = buyProducts;
    }

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }
}
