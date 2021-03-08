package com.dodo1920.persistence;

import com.dodo1920.domain.UserVO;
import com.dodo1920.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
	
}
