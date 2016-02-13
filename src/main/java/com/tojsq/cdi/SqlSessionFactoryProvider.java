/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tojsq.cdi;

import java.io.IOException;
import java.io.InputStream;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author admin
 */
public class SqlSessionFactoryProvider {

    private static final String MYBATIS_CONFIG_XML = "mybatis-config.xml";

    @Produces
    @ApplicationScoped
    public SqlSessionFactory produceFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(SqlSessionFactoryProvider.class.getClassLoader(), MYBATIS_CONFIG_XML);
        if(inputStream==null   ){
            System.out.println("找不到配置文件");
        }else{
            System.out.println("成功加载配置文件");
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

}
