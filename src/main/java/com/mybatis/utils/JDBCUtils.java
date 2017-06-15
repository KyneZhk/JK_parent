package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * JDBC工具类
 */
public class JDBCUtils {
    private static SqlSessionFactory sqlSessionFactory;
    private JDBCUtils(){
        //私有化构造
    }

    static{
        Reader reader = null;
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            //构建sqlSession工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 创建能执行映射文件sql的sqlSession配置文件
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
