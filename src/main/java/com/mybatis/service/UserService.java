package com.mybatis.service;


import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;
import com.mybatis.utils.JDBCUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 业务层
 */
public class UserService {

    /**
     * 新增用户
     */
    @Test
    public void insertUser(){
        SqlSession sqlSession = JDBCUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("jack");
        user.setPassword("123");
        user.setAccount(444.32);
        try {
            int i = userMapper.insertUser(user);
            //提交事务
            sqlSession.commit();
            System.out.println(user.getUsername() + ".." + user.getPassword() + ".." + i);
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

    }

    /**
     * 根据ID查询用户信息
     */
    @Test
    public void selectUserById(){
        SqlSession sqlSession = JDBCUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            User user = userMapper.selectUserById(1);
            sqlSession.commit();
            System.out.println(user.getUsername() + ".." + user.getPassword());
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    /**
     * 查询所有用户信息
     */
    @Test
    public void selectAllUser(){
        SqlSession sqlSession = JDBCUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            List<User> userList = userMapper.selectAllUser();
            sqlSession.commit();
            for (User user : userList) {
                System.out.println(user.getUsername() + ".." + user.getPassword() + ".." + user.getAccount());
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser(){
        SqlSession sqlSession = JDBCUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            User user = userMapper.selectUserById(2);
            user.setUsername("rose");
            userMapper.updateUser(user);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){
        SqlSession sqlSession = JDBCUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            userMapper.deleteUser(2);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }

    }
}













