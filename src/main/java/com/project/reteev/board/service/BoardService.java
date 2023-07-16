package com.project.reteev.board.service;

import java.util.List;
import com.project.reteev.model.Board;

public interface BoardService {

	// 게시판 리스트 출력
	List<Board> getBoardList();

	// 글쓰기 정보가져오기
	Board getWriteElementById(Long id);
	
	// 게시판 글쓰기
	void insertBoard(Board board);

	// 게시판 수정
	void modifyBoard(Long id, Board board);

	// 게시판 삭제
	void deleteBoard(Long id);

	int countAll(String searchText);
}
