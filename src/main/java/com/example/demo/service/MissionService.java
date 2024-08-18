package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.dto.missionDetailDTO;
import com.example.demo.domain.entity.Mission;
import com.example.demo.domain.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * (Mission)表服务接口
 *
 * @author makejava
 * @since 2024-08-11 16:48:50
 */
public interface MissionService extends IService<Mission> {

    HashMap<String, Mission> missionListForUser(User user);

    missionDetailDTO getMissionDetail(Mission mission);

    Mission getMissionById(Integer id);

    Mission getMissionByCode(String code);

//    Mission createMission();

//    Mission missionList2Cache(List<Mission> missionList);


}

