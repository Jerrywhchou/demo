package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.entity.Instance;
import com.example.demo.domain.entity.Mission;
import com.example.demo.domain.entity.User;
import com.example.demo.mapper.InstanceMapper;
import com.example.demo.service.InstanceService;
import com.example.demo.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Instance)表服务实现类
 *
 * @author makejava
 * @since 2024-08-14 23:53:45
 */
@Service("instanceService")
public class InstanceServiceImpl extends ServiceImpl<InstanceMapper, Instance> implements InstanceService {

    @Autowired
    private MissionService missionService;


    @Override
    public Instance createInstance(Mission mission, User user) {
        Instance ins = Instance.builder()
                .id((int) System.currentTimeMillis())
                .code(mission.getCode())
                .status(1)
                .userid(Long.valueOf(user.getId())).build();
        save(ins);
        Instance instance = getById(ins.getId());
        return instance;
    }

    @Override
    public void processRead(Instance instance) {
        instance.setStatus(2);
        Mission mission = missionService.getMissionByCode(instance.getCode());
        System.out.println(instance.getCode()+
                "你参与活动获得" + mission.getAmount() + "个金子，谢谢参与");



    }



}
