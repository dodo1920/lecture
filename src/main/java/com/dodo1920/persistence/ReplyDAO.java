package com.dodo1920.persistence;

import java.util.List;

import com.dodo1920.domain.ReplyVO;

public interface ReplyDAO {
	public void create(ReplyVO vo) throws Exception;
	
	public List<ReplyVO> read(int bno) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
	
	public void delete(int no) throws Exception;
	
	public int getBno(int no) throws Exception;
}
