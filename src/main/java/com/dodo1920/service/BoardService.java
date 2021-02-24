package com.dodo1920.service;

import java.util.List;

import com.dodo1920.domain.BoardVO;
import com.dodo1920.domain.PagingCriteria;

public interface BoardService {
	public boolean insert(BoardVO vo) throws Exception;
	
	public BoardVO read(int no) throws Exception;
	
	public boolean modify(BoardVO vo) throws Exception;
	
	public boolean remove(int no) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriiteria(PagingCriteria cri) throws Exception;
}
