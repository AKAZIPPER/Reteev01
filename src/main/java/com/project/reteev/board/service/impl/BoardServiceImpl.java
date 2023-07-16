package com.project.reteev.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.reteev.board.mapper.BoardMapper;
import com.project.reteev.board.service.BoardService;
import com.project.reteev.model.Board;
import com.project.reteev.pagination.mapper.PaginationMapper;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private PaginationMapper paginationMapper;
	
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
	
	@Override
	public int countAll(String searchText) {
		int result = 0;
		if(searchText == null || searchText.equals("")) {
			searchText = "";
			System.out.println("searchText1 : >> " + searchText);
			result = paginationMapper.boardCount(searchText);
		}else {
			System.out.println("searchText2 : >> " + searchText);
			result = paginationMapper.boardCount(searchText);
		}
		return result;
	}

}
