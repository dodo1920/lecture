package com.dodo1920.springProj;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dodo1920.domain.ReplyVO;
import com.dodo1920.service.ReplyService;

@RestController // 이 클래스가 REST방식의 컨트롤러임을 컴파일러에게 전달
@RequestMapping("/replies")
public class ReplyController {
	@Inject
	private ReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) { // ResponseEntity<String> = <String>타입의 JSON 객체
		System.out.println("REplies POST 호출");
		ResponseEntity<String> entity = null;
		
		try {
			service.addREply(vo);
			entity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}	
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") int bno) {
	      ResponseEntity<List<ReplyVO>> entity = null;
	      try {
	         entity = new ResponseEntity<List<ReplyVO>>(service.listReply(bno), HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // 예외가 발생하면 List<ReplyVO>는 null이므로 >> ResponseEntity<>
	      }
	      return entity;
	   }
	
	@RequestMapping(value="/{no}", method=RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("no") int no, @RequestBody ReplyVO vo) {
		// no : 댓글 번호
		// @RequestBody ReplyVO vo : 유저가 수정한 데이터를 json으로 받아 ReplyVO에 저장
		
		ResponseEntity<String> entity = null;
		
		System.out.println(no + "," + vo.toString());
		
		try {
			vo.setNo(no);
			service.modifyReply(vo);
			
			entity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{no}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("no") int no) {
		ResponseEntity<String> entity = null;
		
		try {
			service.removeReply(no);
			
			entity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
}
