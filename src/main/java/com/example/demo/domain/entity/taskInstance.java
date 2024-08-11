package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class taskInstance {

    private Long id;
    private String Code;
    private Long userid;
    private Integer status;
    private Date gmtCreate;
    private Date gmtModified;


}