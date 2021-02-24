package com.dodo1920.springProj;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dodo1920.domain.BoardVO;
import com.dodo1920.domain.PagingCriteria;
import com.dodo1920.service.BoardService;

@Controller
@RequestMapping("/board/*") // /board/의 하위 모든 URI에 대해 현재 클래스가 동작함을 의미
public class BoardController {
	@Inject
	private BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGet(BoardVO vo, Model model) {
		// 글 등록 페이지 호출
		logger.info("/register를 get호출");
		
		return "/board/registerBoard";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(BoardVO vo, RedirectAttributes rttr) throws Exception {
		// 글 작성 페이지에서 submit버튼 클릭시
		
		logger.info("/register를 post호출");
		logger.info((vo.toString()));
		
		if(service.insert(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("/listAll를 get호출");
		
		List<BoardVO> lst = service.listAll();
		model.addAttribute("boardList", lst);
		
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void readBoard(@RequestParam("no") int no, Model model) throws Exception {
		logger.info("/read를 get호출");
		
		System.out.println("no : " + no);
		model.addAttribute("board", service.read(no));
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String removeBoard(@RequestParam("no") int no, RedirectAttributes rttr) throws Exception {
		logger.info("/remove를 get호출");
		
		if(service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/modi", method=RequestMethod.GET)
	public void modiGet(@RequestParam("no") int no, Model model) throws Exception {
		logger.info("/modi를 get호출");
		
		model.addAttribute("board", service.read(no));
	}
	
	@RequestMapping(value="/modi", method=RequestMethod.POST)
	public String modiBoard(BoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("/modi를 post호출");
		logger.info((vo.toString()));
		
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listAll(PagingCriteria cri, Model model) throws Exception {
		logger.info("/페이징을 이용한 전체 목록 출력");
		logger.info((cri.toString()));
		
		model.addAttribute("boardList", service.listCriiteria(cri));
	}
}
