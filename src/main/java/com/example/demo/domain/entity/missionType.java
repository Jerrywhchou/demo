package com.example.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum MissionType {
    READ(1,"阅读任务"),
    WRITE(2,"写作任务");

    @EnumValue
    int id;
    String description;

    MissionType(int id, String description) {
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