package com.example.demo.mapper;

import com.example.demo.domain.entity.Instance;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Instance)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-14 23:49:41
 */
@Mapper
public interface InstanceMapper extends EasyBaseMapper<Instance> {
}
