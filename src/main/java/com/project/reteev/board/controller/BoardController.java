package com.project.reteev.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.reteev.board.dto.BoardDto;
import com.project.reteev.board.entity.BoardEntity;
import com.project.reteev.board.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/list")
	public String list(@RequestParam(required = false) String message, Model model) {
		List<BoardEntity> board = boardRepository.findAll();
		
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
