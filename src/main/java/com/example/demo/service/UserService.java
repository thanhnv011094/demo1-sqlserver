package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public class UserService extends GeneralService<User> {

	@Override
	public User update(User user, long id) {
		user.setId(id);
		return repository.saveAndFlush(user);
	}
}