package com.example.demo.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.entity.Mission;
import com.example.demo.mapper.MissionMapper;
import com.example.demo.service.MissionService;
import org.springframework.stereotype.Service;
/**
 * (Mission)表服务实现类
 *
 * @author makejava
 * @since 2024-08-11 16:48:53
 */
@Service("missionService")
public class MissionServiceImpl extends ServiceImpl<MissionMapper, Mission> implements MissionService {
}

