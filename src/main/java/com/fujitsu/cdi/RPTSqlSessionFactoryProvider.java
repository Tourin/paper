/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fujitsu.cdi;

import java.io.IOException;
import java.io.InputStream;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author admin
 */
public class RPTSqlSessionFactoryProvider {

    private static final String MYBATIS_CONFIG_XML = "mybatis-config.xml";

    @Produces
    @ApplicationScoped
    @Named("RPT")
    public SqlSessionFactory produceFactory() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_XML);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"RPT");
        return sqlSessionFactory;
    }

}
