package com.example.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;


public enum Reward {
    gold(1,"金子"),
    redPacket(2,"红包");

    @EnumValue
    int id;

    String description;

    Reward(int id, String description) {
        this.id = id;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

}