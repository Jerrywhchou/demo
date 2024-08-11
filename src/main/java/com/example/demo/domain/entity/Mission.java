
package com.example.demo.domain.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
//状态
private Integer status;
//类型
 private Integer type;
//创建时间
 private Date createTime;
//修改时间
 private Date updateTime;
//任务名称
 private String name;
//对应奖励
 private String reward;
//需满足的最低级别要求
 private Integer minumum;
//奖励的数量
 private Integer amount;
}

