package com.example.demo;
import com.example.demo.config.BeanUtils;
import com.example.demo.domain.entity.Instance;
import com.example.demo.mapper.InstanceMapper;
import com.example.demo.service.AsyncService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Component;

@Component
public class batchInsert {

//   private AsyncService asyncService;
//
//   public batchInsert(AsyncService asyncService) {
//       this.asyncService = asyncService;
//   }

//    @Autowired
//    private AsyncService asyncService;
//        @Resource
//    private AsyncService asyncService;
//


    @Test
            public void batchInsert() {
//        AsyncService asyncService = BeanUtils.getBean(AsyncService.class);
                int totalRecords = 10000;
                int batchSize = 2000;
                int threadCount = totalRecords / batchSize;

                CountDownLatch latch = new CountDownLatch(threadCount);

                for (int i = 0; i < threadCount; i++) {
                    List<Instance> batchList = new ArrayList<>();
                    for (int j = 0; j < batchSize; j++) {
                        Instance instance = new Instance();
                        instance.setCode("code_" + ThreadLocalRandom.current().nextInt(1000000));
                        instance.setStatus(ThreadLocalRandom.current().nextInt(3));
                        instance.setUserid(ThreadLocalRandom.current().nextLong(1000000));
                        instance.setCreateTime(new Date());
                        instance.setUpdateTime(new Date());
                        batchList.add(instance);
                    }
                    while(true){
                        try{
                            asyncService.asyncBatchInsertInstance(latch, batchList);
                            break;
                        }catch (TaskRejectedException e){
                            try{
                                Thread.sleep(1000);
                            }catch (Exception e2){}
                        }
                    }
                }

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

        System.out.println("Batch insert completed!");
            }
        }
