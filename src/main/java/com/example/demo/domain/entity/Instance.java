package com.example.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Instance)表实体类
 *
 * @author makejava
 * @since 2024-08-14 23:51:25
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("instance")
public class Instance {
//自增ID
 @TableId
private Integer id;
//唯一编码,前台使用
 private String code;
//状态  0-失效， 1-已创建未完成， 2-完成
 private Integer status;
//用户id
 private Long userid;
//创建时间
 private Date createTime;
//修改时间
 private Date updateTime;
}

