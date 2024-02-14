package com.anys34.tripcord.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.anys34.tripcord.global.feign")
public class FeignConfig {
}
