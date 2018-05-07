package com.lingcloud.spring.model.db;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;

@Entity
public class UserDBModel extends BaseDBModel {
    @UniqueElements
    private String account;
    @UniqueElements
    private String name;
    private String nickName;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String password;
    @UniqueElements
    private String email;
    @UniqueElements
    private String phone;


    public UserDBModel(String account, String password){
        this.account = account;
        this.password = password;
    }
}
