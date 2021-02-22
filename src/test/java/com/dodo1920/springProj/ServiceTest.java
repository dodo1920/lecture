package com.dodo1920.springProj;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dodo1920.domain.BoardVO;
import com.dodo1920.persistence.BoardDAO;
import com.dodo1920.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class) // 현재 클래스가 Sprint-test(JUnit4) 와 함께 동작
@ContextConfiguration(
      locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}
) // 위 경로에서 root-context.xml 파일을 찾아 로딩
public class ServiceTest {
	
	@Inject
	private BoardService service;
	
//	@Test
//	public void insert() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("서비스테스트");
//		vo.setContent("서비스테스트중");
//		vo.setWriter("dodo1920");
//		
//		if(service.insert(vo)) {
//			System.out.println("서비스단에서 인서트 성공!");
//		}
//	}
//	
//	@Test
//	public void read() throws Exception {
//		System.out.println(service.read(2).toString());
//	}
//	
//	@Test
//	public void modify() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setNo(2);
//		vo.setTitle("서비스 업뎃");
//		vo.setContent("서비스 업데이트됨");
//		vo.setWriter("do");
//		
//		if(service.modify(vo)) {
//			System.out.println("서비스 업데이트 기능 정상작동 확인");
//		};
//	}
//	
//	@Test
//	public void remove() throws Exception {
//		if(service.remove(4)) {
//			System.out.println("1행이 삭제되었습니다.");
//		}
//	}
	
	@Test
	public void listAll() throws Exception {
		System.out.println(service.listAll().toString());
	}
}
