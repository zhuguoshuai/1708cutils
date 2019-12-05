package com.bw.service;

import java.util.List;

import com.bw.bean.User;

public interface UserService {
	public List<User> selectList();
	public int add(User user); 
}
