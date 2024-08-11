package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_test {

    private Long id;

    private String userName;

    private String password;

    private String type;

    private String status;

    private Date gmtCreate;

    private Date gmtModified;

}