package com.project.reteev.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.reteev.board.entity.BoardEntity;
import com.project.reteev.board.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardEntity> board = boardRepository.findAll();
		
		model.addAttribute("lists", board);
		return "/views/board/list";
	}
	
	@GetMapping("/write")
	public String write(Model model) {

		return "/views/board/write";
	}
	
	@PostMapping("/insert")	
	public String insert(BoardEntity vo) {
		boardRepository.save(vo);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")	
	public String modify(@RequestParam("id") int id) {
		
		return "/views/board/updateBoard";
	}
}
