package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;

@Service
public class RoleService extends GeneralService<Role> {

	@Override
	public Role update(Role role, long id) {
		role.setId(id);
		return repository.saveAndFlush(role);
	}
}