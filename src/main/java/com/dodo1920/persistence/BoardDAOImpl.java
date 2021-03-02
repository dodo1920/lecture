package com.dodo1920.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dodo1920.domain.BoardVO;
import com.dodo1920.domain.PagingCriteria;
import com.dodo1920.domain.SearchCriteria;

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

	@Override
	public List<BoardVO> listBoardPaging(int page) throws Exception {
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		return ses.selectList(namespace + ".listBoardPaging", page);
	}

	@Override
	public List<BoardVO> listBoardCriteria(PagingCriteria cri) throws Exception {
		return ses.selectList(namespace + ".listBoardCriteria", cri);
	}

	@Override
	public int getTotalBoardCnt() throws Exception {
		return ses.selectOne(namespace + ".getTotalBoardCnt");
	}

	@Override
	public List<BoardVO> goSearch(SearchCriteria scri) throws Exception {
		return ses.selectList(namespace + ".goSearch", scri);
	}

	@Override
	public List<BoardVO> searchCriteria(PagingCriteria cri, SearchCriteria scri) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("searchType", scri.getSearchType());
		params.put("searchWord", scri.getSearchWord());
		params.put("pageStart", cri.getPageStart());
		params.put("perPageNum", cri.getPerPageNum());
		
		return ses.selectList(namespace + ".searchCriteria", params);
	}

	@Override
	public int getTotalSearchBoardCnt(SearchCriteria scri) throws Exception {
		return ses.selectOne(namespace + ".getTotalSearchBoardCnt", scri);
	}

}
