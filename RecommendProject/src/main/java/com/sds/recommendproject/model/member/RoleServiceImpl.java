package com.sds.recommendproject.model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.recommendproject.domain.Role;


@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDAO roleDAO;
	
	public Role selectByName(String role_name) {
		return roleDAO.selectByName(role_name);
	}
	
}
