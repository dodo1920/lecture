package com.dodo1920.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dodo1920.domain.ReplyVO;
import com.dodo1920.persistence.BoardDAO;
import com.dodo1920.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;
	
	@Inject
	private BoardDAO bdao;
	
	@Override
	public void addREply(ReplyVO vo) throws Exception {
		dao.create(vo); // 댓글 insert
		bdao.updateReply(vo.getBno(), 1); // 댓글이 달린 부모글에 댓글 수 1 증가
		
	}

	@Override
	public List<ReplyVO> listReply(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void removeReply(int no) throws Exception {
		int bno = dao.getBno(no); // 삭제되는 댓글의 부모글 알아오기
		dao.delete(no);
		bdao.updateReply(bno, -1);
	}

}
