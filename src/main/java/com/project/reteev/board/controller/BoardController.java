package com.project.reteev.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.reteev.board.entity.BoardEntity;
import com.project.reteev.board.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/list")
	public String list(@RequestParam(required = false) String message,
						Model model, 
						@PageableDefault(size = 4) Pageable  pageable,
						@RequestParam(required = false, defaultValue = "") String searchText) 
	{
//		Page<BoardEntity> board =  boardRepository.findAll(pageable);
		Page<BoardEntity> board =  boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
		int startPage = Math.max(1, board.getPageable().getPageNumber() - 14); 
		int endPage = Math.min(board.getTotalPages(), board.getPageable().getPageNumber() + 14);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("message", message);
		model.addAttribute("lists", board);
		
		return "/views/board/list";
	}
	
	@GetMapping("/write")
	public String write(Model model, @RequestParam(required = false) Long id) {
		if(id == null) {
			model.addAttribute("board" , new BoardEntity());
		}else {
			BoardEntity board = boardRepository.findById(id).orElse(null);
			model.addAttribute("board" , board);
		}
		
		return "/views/board/write";
	}
	
	@PostMapping("/insert")	
	public String insert(BoardEntity vo) {
		boardRepository.save(vo);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")	
	public String delete(Long id, RedirectAttributes re) {
		System.out.println("id : " + id);
		boardRepository.deleteById(id);
		
		re.addAttribute("message", "삭제완료");
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	@ResponseBody
	public void modify(BoardEntity vo) {

		@SuppressWarnings("unused")
		BoardEntity boardEntity = boardRepository.save(vo);
	}
}
