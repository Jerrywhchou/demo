package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.entity.Instance;
import com.example.demo.mapper.EasyBaseMapper;
import com.example.demo.mapper.InstanceMapper;
import com.example.demo.service.AsyncService;
import com.example.demo.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class AsyncServiceImpl extends ServiceImpl<InstanceMapper, Instance> implements AsyncService {

    @Autowired
    private InstanceMapper instanceMapper;
    
    @Override
    @Async("AsyncExecutor")
    public void asyncBatchInsertInstance(CountDownLatch countDownLatch, List<Instance> InstanceList) {
        try{
            System.out.println("start batch insert");
            int i = instanceMapper.insertBatchSomeColumn(InstanceList);
            System.out.println("end batch insert");
        }finally {
            countDownLatch.countDown();
        }
    }
}