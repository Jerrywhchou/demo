package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class reward {

    private Long id;
    private String code;
    private String type;
    private Long amount;
    private Integer status;
    private String createBy;
    private String updateBy;
    private Date gmtCreate;
    private Date gmtModified;

}