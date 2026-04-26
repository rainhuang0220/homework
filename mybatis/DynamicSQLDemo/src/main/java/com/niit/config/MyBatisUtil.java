package com.niit.config;

import com.niit.mapper.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class MyBatisUtil {

    public static SqlSessionFactory getSession()
    {
        DataSource ds=new PooledDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/mybatis_demo",
                "root",
                "root"
        );
        Environment ev=new Environment("development",
                new JdbcTransactionFactory(), ds);
        Configuration configuration=new Configuration(ev);
        configuration.addMapper(UserMapper.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
