package com.example.demo.controller;

import com.example.demo.domain.entity.Instance;
import com.example.demo.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
@EnableAutoConfiguration
@RestController
@RequestMapping("/test")
public class insertController {

   private final AsyncService asyncService;

   @GetMapping("/insert")
            public void batchInsert() {
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