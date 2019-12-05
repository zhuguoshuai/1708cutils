package com.bw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.bean.User;
import com.bw.mapper.UserMapper;
@Service
public class UserServiceImp implements UserService {
@Autowired
private UserMapper mapper;
	@Override
	public List<User> selectList() {
		// TODO Auto-generated method stub
		return mapper.selectList();
	}
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return mapper.add(user);
	}

}
