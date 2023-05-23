package com.project.reteev.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.reteev.board.mapper.BoardMapper;
import com.project.reteev.board.service.BoardService;
import com.project.reteev.model.Board;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<Board> getBoardList(){
		return boardMapper.getBoardList();
	}
	
	@Override
	public Board getWriteElementById(Long id) {
		return boardMapper.getWriteElementById(id);
	};
	
	@Override
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
	}
	
	@Override
	public void modifyBoard(Long id, Board board) {
		boardMapper.modifyBoard(id, board);
	}
	
	@Override
	public void deleteBoard(Long id) {
		boardMapper.deleteBoard(id);
	}

}
