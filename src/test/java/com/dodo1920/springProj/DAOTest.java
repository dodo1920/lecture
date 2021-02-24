package com.dodo1920.springProj;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dodo1920.domain.BoardVO;
import com.dodo1920.domain.PagingCriteria;
import com.dodo1920.persistence.BoardDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class) // 현재 클래스가 Sprint-test(JUnit4) 와 함께 동작
@ContextConfiguration(
      locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}
) // 위 경로에서 root-context.xml 파일을 찾아 로딩
public class DAOTest {
	
	@Inject
	private BoardDAOImpl dao;
	
//	@Test
//	public void insertBoard() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("인스트 귀찮");
//		vo.setContent("언제까지 해야해...");
//		vo.setWriter("dodo1920");
//		
//		int i = dao.insert(vo);
//		
//		if(i == 1) {
//			System.out.println("인서트 성공!");
//		}		
//	}
//	
//	@Test
//	public void readBoard() throws Exception {
//		BoardVO vo = new BoardVO();
//		
//		vo = dao.readBoard(2);
//		
//		System.out.println(vo.toString());
//	}
//	
//	@Test
//	public void updateBoard() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setNo(1);
//		vo.setTitle("업데이트");
//		vo.setContent("수정했다!");
//		vo.setWriter("dodo1920");
//		
//		int i = dao.update(vo);
//		
//		if(i == 1) {
//			System.out.println("1행이 잘 업데이트 되었습니다.");
//		}
//	}
//	
//	@Test
//	public void deleteBoard() throws Exception {
//		int i = dao.delete(1);
//		if(i == 1) {
//			System.out.println("1행이 잘 제거되었습니다.");
//		}
//	}
//	
//	@Test
//	public void listBoard() throws Exception {
//		List<BoardVO> lst = new ArrayList<BoardVO>();
//		
//		lst = dao.listBoard();
//		
//		System.out.println(lst.toString());
//	}
//	
//	@Test
//	public void testListPaging() throws Exception {
//		int page = 1;
//		
//		System.out.println(dao.listBoardPaging(page).toString());
//		
//	}
//	
//	@Test
//	public void testListCriteria() throws Exception {
//		PagingCriteria cri = new PagingCriteria();
//		cri.setPage(1);
//		cri.setPerPageNum(20);
//		
//		System.out.println(dao.listBoardCriteria(cri).toString());
//	}
	
	@Test
	public void testGetBoardCount() throws Exception {
		System.out.println(dao.getTotalBoardCnt());
	}
}
