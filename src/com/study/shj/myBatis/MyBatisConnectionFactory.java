package com.study.shj.myBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisConnectionFactory {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis_config.xml";
        try (Reader reader = Resources.getResourceAsReader(resource)){
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
