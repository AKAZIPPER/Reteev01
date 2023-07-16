package com.project.reteev.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.reteev.model.Board;

@Mapper
public interface BoardMapper {

	// 게시판 리스트 출력
	List<Board> getBoardList();
	
	// 게시판 수정
	Board getWriteElementById(Long id);

	// 게시판 글쓰기
	void insertBoard(Board board);

	// 게시판 수정
	//1. mapper에 @Param("B")을 넣어줬으면 Mapper에서 #{B.A}로 사용
	//2. maeppr에 @Param("B")를 안 넣어줬으면 Mapper에서 #{A}로 사용
	void modifyBoard(@Param("id") Long id, @Param("board") Board board);

	// 게시판 삭제
	void deleteBoard(Long id);

	int countAll();

	
}
