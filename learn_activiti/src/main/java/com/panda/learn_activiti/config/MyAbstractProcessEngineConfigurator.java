package com.panda.learn_activiti.config;

import org.activiti.engine.cfg.ProcessEngineConfigurator;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyAbstractProcessEngineConfigurator implements ProcessEngineConfigurationConfigurer {

    @Override
    public void configure(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        List<ProcessEngineConfigurator> list = new ArrayList<>();
        list.add(new MyProcessEngineConfigurator());
        springProcessEngineConfiguration.setConfigurators(list);
    }
}
