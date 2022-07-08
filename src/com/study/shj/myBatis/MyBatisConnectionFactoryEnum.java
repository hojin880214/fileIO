package com.study.shj.myBatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;

@RequiredArgsConstructor
public enum MyBatisConnectionFactoryEnum {
    INSTANCE;
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
