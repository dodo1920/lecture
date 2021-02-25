package com.dodo1920.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dodo1920.domain.BoardVO;
import com.dodo1920.domain.PagingCriteria;
import com.dodo1920.domain.SearchCriteria;
import com.dodo1920.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public boolean insert(BoardVO vo) throws Exception {
		boolean result = false;
		
		int i = dao.insert(vo);
		
		if(i == 1) {
			result = true;
		}
		
		return result;
	}

	@Override
	public BoardVO read(int no) throws Exception {
		// 이후에 조회수 증가하는 것을 AOP의 트랜잭션 처리로 마감
		BoardVO vo = dao.readBoard(no);
		return vo;
	}

	@Override
	public boolean modify(BoardVO vo) throws Exception {
		boolean result = false;
		
		int i = dao.update(vo);
		
		if(i == 1) {
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean remove(int no) throws Exception {
		boolean result = false;
		
		int i = dao.delete(no);
		
		if(i == 1) {
			result = true;
		}
		
		return result;
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		
		return dao.listBoard();
	}

	@Override
	public List<BoardVO> listCriiteria(PagingCriteria cri) throws Exception {
		return dao.listBoardCriteria(cri);
	}

	@Override
	public int getTotalBoardCnt() throws Exception {
		return dao.getTotalBoardCnt();
	}

	@Override
	public List<BoardVO> goSearch(SearchCriteria scri) throws Exception {
		return dao.goSearch(scri);
		
	}
	

}
