package com.bw.mapper;

import java.util.List;

import com.bw.bean.User;

public interface UserMapper {
public List<User> selectList();
public int add(User user); 
}
