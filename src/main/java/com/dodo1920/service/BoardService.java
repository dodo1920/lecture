package com.dodo1920.service;

import java.util.List;

import com.dodo1920.domain.BoardVO;
import com.dodo1920.domain.PagingCriteria;
import com.dodo1920.domain.SearchCriteria;

public interface BoardService {
	public boolean insert(BoardVO vo) throws Exception;
	
	public BoardVO read(int no) throws Exception;
	
	public boolean modify(BoardVO vo) throws Exception;
	
	public boolean remove(int no) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriiteria(PagingCriteria cri) throws Exception;

	public int getTotalBoardCnt() throws Exception;

	public List<BoardVO> goSearch(SearchCriteria scri) throws Exception;

	public List<BoardVO> searchCriteria(PagingCriteria cri, SearchCriteria scri) throws Exception;

	public int getTotalSearchBoardCnt(SearchCriteria scri) throws Exception;;
}
