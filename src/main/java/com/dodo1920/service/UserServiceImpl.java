package com.dodo1920.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dodo1920.domain.UserVO;
import com.dodo1920.dto.LoginDTO;
import com.dodo1920.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		
		return dao.login(dto);
	}

}
