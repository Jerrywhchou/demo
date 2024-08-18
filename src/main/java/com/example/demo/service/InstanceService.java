package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.entity.Instance;
import com.example.demo.domain.entity.Mission;
import com.example.demo.domain.entity.User;

/**
 * (Instance)表服务接口
 *
 * @author makejava
 * @since 2024-08-14 23:53:21
 */
public interface InstanceService extends IService<Instance> {

    Instance createInstance(Mission mission, User user);

    void processRead(Instance instance);

    void processWrite(String inputWrite, Instance instance);
}

