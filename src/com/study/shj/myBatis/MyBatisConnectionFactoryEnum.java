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
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    private void initialize() {
        try {
            System.out.println("11111111111111111111111111111111111111111");
            String resource = "mybatis_config.xml";
            Reader reader = Resources.getResourceAsReader(resource);

//            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }

    }
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
