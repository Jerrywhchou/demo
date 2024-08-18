package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@ComponentScan("com.example.demo")
public class AsyncConfig implements AsyncConfigurer {

    @Override
    @Bean("AsyncExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        int i = Runtime.getRuntime().availableProcessors();
        threadPool.setCorePoolSize( 2*i + 1);
        threadPool.setMaxPoolSize(100);
        threadPool.setQueueCapacity(10);
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        threadPool.setAwaitTerminationSeconds(60);
        threadPool.setThreadNamePrefix("AsyncExecutor-");
        threadPool.initialize();
        return threadPool;

    }
}
