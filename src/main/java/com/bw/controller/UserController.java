package com.bw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.User;
import com.bw.service.UserService;
import com.bw.utils.DateUtils;
import com.bw.utils.StringUtils;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("list")
	public String list(Model model) {
		List<User> selectList = service.selectList();
		model.addAttribute("list", selectList);
		return "list";
	}

	@RequestMapping("add")
	@ResponseBody
	public Object add(User user) {
 
        
		if (StringUtils.isEmpty(user.getPhone())||StringUtils.isEmpty(user.getEmail())||
				StringUtils.isEmpty(user.getNickname())  ) {
		 
			return false;
		}else{
			int i = service.add(user);
			return true;
		}
 
	}
}
