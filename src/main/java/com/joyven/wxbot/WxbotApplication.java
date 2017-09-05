package com.joyven.wxbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.stream.Stream;


@SpringBootApplication(scanBasePackages = {"com.joyven.*"})
public class WxbotApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxbotApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(WxbotApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(WxbotApplication.class, args);
        LOGGER.debug(ctx.toString());
        LOGGER.debug("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        Stream.of(beanNames).forEach(LOGGER::debug);
    }
}
