package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    private Long id;
    private String name;
    private String Code;

    private String type;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;



    private String reward;


    }