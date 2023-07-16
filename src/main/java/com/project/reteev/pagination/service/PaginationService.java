package com.project.reteev.pagination.service;

import java.util.List;

import com.project.reteev.model.Board;
import com.project.reteev.model.PageDTO;

public interface PaginationService {
	
	// 해당 페이지 리스트
	List<Board> pagingList(int pageNumber, String searchText);

	// 페이징처리
	PageDTO pagingParam(int pageNumber, String searchText);

	// 게시판 검색
	List<Board> search(String searchText);
}
