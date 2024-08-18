package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.entity.Instance;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public interface AsyncService extends IService<Instance> {

    @Async
    void asyncBatchInsertInstance(CountDownLatch countDownLatch, List<Instance> InstanceList);
}
