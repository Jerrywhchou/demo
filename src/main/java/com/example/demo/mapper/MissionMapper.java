package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.entity.Mission;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Mission)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-11 16:48:45
 */
@Mapper
public interface MissionMapper extends BaseMapper<Mission> {
}
