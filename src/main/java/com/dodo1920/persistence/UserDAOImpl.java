package com.dodo1920.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dodo1920.domain.UserVO;
import com.dodo1920.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Inject
	private SqlSession ses;
	
	private static String namespace = "com.dodo1920.mappers.UserMapper";
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		
		return ses.selectOne(namespace + ".login", dto);
	}

}
