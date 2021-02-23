package com.dodo1920.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dodo1920.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession ses;
	private static String namespace = "com.dodo1920.mappers.BoardMapper";
	
	@Override
	public int insert(BoardVO vo) throws Exception {
		return ses.insert("com.dodo1920.mappers.BoardMapper" + ".insertBoard", vo);
	}

	@Override
	public BoardVO readBoard(int no) throws Exception {
		// TODO Auto-generated method stub
		return ses.selectOne(namespace + ".readBoard", no);
	}

	@Override
	public int update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return ses.update(namespace + ".updateBoard", vo);
	}

	@Override
	public int delete(int no) throws Exception {
		// TODO Auto-generated method stub
		return ses.update(namespace + ".deleteBoard", no);
	}

	@Override
	public List<BoardVO> listBoard() throws Exception {
		// TODO Auto-generated method stub
		return ses.selectList(namespace + ".listBoard");
	}

}
