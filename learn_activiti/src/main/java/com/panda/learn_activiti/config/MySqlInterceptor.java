package com.panda.learn_activiti.config;

import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Locale;
import java.util.Properties;

@Intercepts(
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
)

@Component
public class MySqlInterceptor implements Interceptor {

    private Properties properties;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Executor executor = (Executor) invocation.getTarget();
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        Object arg = invocation.getArgs()[1];

        BoundSql boundSql = mappedStatement.getBoundSql(arg);

        //获取到原始sql语句
        String sql = boundSql.getSql();

        sql = convertTableNameToLower(sql);

        Field field = boundSql.getClass().getDeclaredField("sql");
        field.setAccessible(true);
        field.set(boundSql, sql);
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    private String convertTableNameToLower(String sql) {
        sql = sql.toLowerCase();
        System.out.println(sql.toLowerCase());
        return sql;
    }

}
