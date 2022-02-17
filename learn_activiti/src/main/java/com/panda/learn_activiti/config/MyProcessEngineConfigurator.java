package com.panda.learn_activiti.config;

import org.activiti.engine.cfg.AbstractProcessEngineConfigurator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.apache.ibatis.session.SqlSessionFactory;


public class MyProcessEngineConfigurator extends AbstractProcessEngineConfigurator {

    @Override
    public void configure(ProcessEngineConfigurationImpl processEngineConfiguration) {

        SqlSessionFactory sqlSessionFactory = processEngineConfiguration.getSqlSessionFactory();
        //这里是自定义的MySqlInterceptor，跟上文一样
        sqlSessionFactory.getConfiguration().addInterceptor(new MySqlInterceptor());

    }

}
