package com.dodo1920.service;

import com.dodo1920.domain.UserVO;
import com.dodo1920.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}
