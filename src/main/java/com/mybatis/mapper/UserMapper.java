package com.mybatis.mapper;

import com.mybatis.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */

    int insertUser(User user) throws Exception;

    /**
     * 修改用户
     * @param user
     * @return
     * @throws Exception
     */
    int updateUser(User user) throws Exception;

    /**
     * 删除用户
     * @param uid
     * @return
     * @throws Exception
     */
    int deleteUser(int uid) throws Exception;

    /**
     * 根据ID查询用户信息
     * @param uid
     * @return
     * @throws Exception
     */
    User selectUserById(int uid) throws Exception;

    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    List<User> selectAllUser() throws Exception;

}
