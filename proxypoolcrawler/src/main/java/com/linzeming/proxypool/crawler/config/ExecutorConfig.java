package com.linzeming.proxypool.crawler.config;

import com.linzeming.proxypool.crawler.util.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ExecutorConfig {
    @Bean(value = "validateProxyIpQueueConsumerExecutor")
    ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(Constants.ValidateProxyIpQueueConsumerThreadCount);
        threadPoolTaskExecutor.setMaxPoolSize(Constants.ValidateProxyIpQueueConsumerThreadCount);
        threadPoolTaskExecutor.setQueueCapacity(Constants.ValidateProxyIpQueueConsumerThreadCount);
        threadPoolTaskExecutor.setThreadNamePrefix("needVerifyProxyQueueConsumerExecutor");
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return threadPoolTaskExecutor;
    }
}
