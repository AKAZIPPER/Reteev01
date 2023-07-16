package com.project.reteev.pagination.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.reteev.model.Board;
import com.project.reteev.model.Search;

@Mapper
public interface PaginationMapper {

	List<Board> pagingList(Search pagingParam);

	// 게시판 전체 글 갯수 조회
	int boardCount(String searchText);

	List<Board> search(String searchText);

}
