package com.dodo1920.persistence;

import java.util.List;

import com.dodo1920.domain.BoardVO;

public interface BoardDAO {
	// 1. 글 생성 (이름)
	public int insert(BoardVO vo) throws Exception; // 원래는 발생할 정확한 Exception명을 다 써주는 것이 좋음 => 무슨 에러가 났는지 확인 가능해지기 떄문
	
	// 2. 상세 글 조회 (이름)
	public BoardVO readBoard(int no) throws Exception;
	
	public int update(BoardVO vo) throws Exception;
	
	public int delete(int no) throws Exception;
	
	public List<BoardVO> listBoard() throws Exception;
}
