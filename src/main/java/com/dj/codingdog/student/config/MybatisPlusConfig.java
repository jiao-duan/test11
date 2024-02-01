package com.dj.codingdog.student.config;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

@EnableTransactionManagement
@Configuration
@MapperScan({"com.dj.codingdog.student.mapper.**"})
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            /**
             * 插入元对象字段填充（用于插入时对公共字段的填充）
             *
             * @param metaObject 元对象
             */
            @Override
            public void insertFill(MetaObject metaObject) {
                this.setFieldValByName("addTime", LocalDateTime.now(), metaObject);
                this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
            }

            /**
             * 更新元对象字段填充（用于更新时对公共字段的填充）
             *
             * @param metaObject 元对象
             */
            @Override
            public void updateFill(MetaObject metaObject) {
                this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
            }
        };
    }

    @Bean
    public GlobalConfig.DbConfig dbConfig() {
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setLogicDeleteField("isDelete");
        dbConfig.setLogicDeleteValue("1");
        dbConfig.setLogicNotDeleteValue("0");
        return dbConfig;
    }

}
