package com.example.boot.rest.service.impl;

import com.example.boot.exception.UserException;
import com.example.boot.rest.service.UserService;
import com.example.boot.rest.dao.UserMapper;
import com.example.boot.rest.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final
    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 用户详情
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        try {
            return userMapper.findById(id);
        } catch (Exception e) {
            logger.info("查询用户异常：" + e.getMessage());
            throw new UserException("查询用户详情异常");
        }
    }

    /**
     * 用户列表
     * @return
     */
    @Override
    public List<User> list() {
        try {
            return userMapper.list();
        } catch (Exception e) {
            logger.info("查询用户列表异常：" + e.getMessage());
            throw new UserException("查询用户列表异常");
        }
    }

    /**
     * 编辑用户
     * @param user
     * @return
     */
    @Override
    public boolean modifyName(User user) {
        try {
            return userMapper.modifyName(user) == 1;
        } catch (Exception e) {
            logger.info("编辑用户异常：" + e.getMessage());
            throw new UserException("编辑用户异常");
        }

    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public boolean delete(String id) {
        try {
            return userMapper.delete(id) == 1;
        } catch (Exception e) {
            logger.info("删除用户异常：" + e.getMessage());
            throw new UserException("删除用户异常");
        }

    }

    /**
     * 新建用户
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        try {
            return userMapper.addUser(user) == 1;
        } catch (Exception e) {
            logger.info("新建用户异常：" + e.getMessage());
            throw new UserException("新建用户异常");
        }
    }
}
