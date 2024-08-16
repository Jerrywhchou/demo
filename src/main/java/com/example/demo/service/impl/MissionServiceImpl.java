package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.dto.missionDetailDTO;
import com.example.demo.domain.entity.Mission;
import com.example.demo.domain.entity.User;
import com.example.demo.mapper.MissionMapper;
import com.example.demo.service.MissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * (Mission)表服务实现类
 *
 * @author makejava
 * @since 2024-08-11 16:48:53
 */
@Service("missionService")
public class MissionServiceImpl extends ServiceImpl<MissionMapper, Mission> implements MissionService {



    @Override
    public HashMap<String, Mission> missionListForUser(User user) {
        LambdaQueryWrapper<Mission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.lt(Mission::getMinumum, user.getLevel());
        List<Mission> missions = this.list(queryWrapper);
        HashMap<String, Mission> map = null;
        if (missions.isEmpty()) {
            System.out.println("no available mission");
        } else {
            map = new HashMap<>();
            for (Mission mission : missions) {
                map.put(mission.getName(), mission);
            }
            map.values().forEach(value -> {
                System.out.println(value.getName() + " " + value.getAmount() +" " + value.getReward());
            });
        }
        return map;
    }




    @Override
    public missionDetailDTO getMissionDetail(Mission mission) {
        missionDetailDTO detail = new missionDetailDTO();
        BeanUtils.copyProperties(mission,detail);
        return detail;
    }

    @Override
    public Mission getMissionById(Integer id) {
        Mission mission = this.getById(id);
        return mission;

    }

    @Override
    public Mission getMissionByCode(String code){
        LambdaQueryWrapper<Mission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Mission::getCode, code);
        Mission mission = this.getOne(queryWrapper);
        return mission;
    }




}

