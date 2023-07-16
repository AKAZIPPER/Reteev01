package com.project.reteev.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.reteev.board.service.BoardService;
import com.project.reteev.model.Board;
import com.project.reteev.model.PageDTO;
import com.project.reteev.pagination.service.PaginationService;

@Controller
@RequestMapping("/board/mybatis")
public class MybatisBoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private PaginationService paginationService;
	
	@GetMapping("/list")
	public String list(Model model,
					   @RequestParam(value = "page", required = false, defaultValue = "1") int pageNumber,
					   @RequestParam(required = false) String searchText,
						@RequestParam(required = false) String paramData) {
		
		List<Board> pagingList = paginationService.pagingList(pageNumber, searchText);
		int countAll = boardService.countAll(searchText);
		PageDTO pageDTO = paginationService.pagingParam(pageNumber, searchText);
		System.out.println("pageDTO : " + pageDTO);
		System.out.println("pageNumber : " + pageNumber);
		System.out.println("searchText : " + searchText);
		
		model.addAttribute("lists", pagingList); //해당 페이지 리스트
		model.addAttribute("paging", pageDTO); 	 //페이징처리
		model.addAttribute("countAll", countAll); 	 //페이징처리
		
		
		
		
		// 게시판 목록에서 해당페이지로 가는 검색어로 다시 리스트페이지 호출
		model.addAttribute("searchText", searchText);
		System.out.println("paramData : " + paramData);
		System.out.println("MybatisBoardController.list 작동");
		
		return "/views/board/list";
	}
	
	@GetMapping("/write")
	public String write(Model model, @RequestParam(required = false) Long id) {		
		if(id==null) {
			model.addAttribute("board", new Board());
		}else {
			Board board = boardService.getWriteElementById(id);
			model.addAttribute("board", board);		
		}
		return "/views/board/write";
	}
	
	@PostMapping("/insert")	
	public String insert(Board board) {		
		boardService.insertBoard(board);		
		return "redirect:/board/mybatis/list";
	}
	
	@PostMapping("/modify")
	@ResponseBody
	public void modify(@RequestParam(required = false) Long id ,Board board) {
		boardService.modifyBoard(id, board);
	}
	
	@GetMapping("/delete")	
	public String delete(@RequestParam(required = false) Long id, RedirectAttributes re) {		
		boardService.deleteBoard(id);
		re.addAttribute("message", "삭제완료");		
		return "redirect:/board/mybatis/list";
	}
}
