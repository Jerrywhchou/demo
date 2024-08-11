package com.example.demo.domain.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2024-08-10 23:53:47
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
//自增ID
 @TableId
private Integer id;
//唯一编码,前台使用
private String username;
//状态
 private Integer status;
//级别
private Long level;
//类型
 private Integer type;
//创建时间
 private Date gmtCreate;
//修改时间
 private Date gmtModified;
//密码
 private String password;
}

