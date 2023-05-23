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

@Controller
@RequestMapping("/board/mybatis")
public class MybatisBoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {		
		List<Board> board = boardService.getBoardList();		
		model.addAttribute("lists", board);		
		return "/views/board/list";
	}
	
	@GetMapping("/write")
	public String write(Model model, @RequestParam(required = false) Long id) {		
		Board board = boardService.getWriteElementById(id);
		model.addAttribute("board", board);		
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
