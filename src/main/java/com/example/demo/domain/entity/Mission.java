
package com.example.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * (Mission)表实体类
 *
 * @author makejava
 * @since 2024-08-11 16:48:44
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("mission")
public class Mission {
//自增ID
@TableId
private Integer id;
//唯一编码,前台使用
private String code;
//状态  0-失效， 1-有效
private Integer status;
//类型
private missionType type;
//创建时间
 private Date createTime;
//修改时间
 private Date updateTime;
//任务名称
 private String name;
//对应奖励
 private Reward reward;
//需满足的最低级别要求
 private Integer minumum;
//奖励的数量
 private Integer amount;
}

