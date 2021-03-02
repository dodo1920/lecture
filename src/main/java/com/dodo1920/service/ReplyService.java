package com.dodo1920.service;

import java.util.List;

import com.dodo1920.domain.ReplyVO;

public interface ReplyService {
	public void addREply(ReplyVO vo) throws Exception;
	
	public List<ReplyVO> listReply(int bno) throws Exception;
	
	public void modifyReply(ReplyVO vo) throws Exception;
	
	public void removeReply(int no) throws Exception;
}
