package com.project.reteev.pagination.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.reteev.model.Board;
import com.project.reteev.model.PageDTO;
import com.project.reteev.model.Search;
import com.project.reteev.pagination.mapper.PaginationMapper;
import com.project.reteev.pagination.service.PaginationService;

@Service
public class PaginationServiceImpl implements PaginationService{

	@Autowired
	PaginationMapper paginationMapper;
	
	int pageLimit = 7; // 한 페이지당 보여줄 글 갯수
	
	int blockLimit = 4; // 하단에 보여줄 페이지 번호 갯수
	
	// 해당 페이지 리스트
	@Override
	public List<Board> pagingList(int pageNumber, String searchText){
		int pageStart = (pageNumber - 1) * pageLimit;
		Search searchVo = new Search();
		searchVo.setStart(pageStart);
		searchVo.setLimit(pageLimit);
		if(searchText == null || searchText.equals("")) {
			searchVo.setSearch("");			
		}else {
			searchVo.setSearch(searchText);
		}
		List<Board> pagingList = paginationMapper.pagingList(searchVo);
		System.out.println("pagingList : " + pagingList);
		return pagingList;
	}
	
	@Override
	public PageDTO pagingParam(int pageNumber, String searchText) {
		// 전체 글 갯수 조회
		int boardCount = paginationMapper.boardCount(searchText);
		// 전체 페이지 갯수 계산(10/3=3.3333 => 4 / 올림처리)
		int maxPage = (int)(Math.ceil((double) boardCount / pageLimit));
		// 시작 페이지 값 계산 (1, 4, 7, 10, ~~~)
		int startPage = (((int)(Math.ceil((double) pageNumber / blockLimit))) - 1) * blockLimit + 1;
		// 끝 페이지 갑 계산 (3, 6, 9, 12, ~~~)
		int endPage = startPage + blockLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageDTO pDto = new PageDTO();
		pDto.setPage(pageNumber);
		pDto.setMaxPage(maxPage);
		pDto.setStartPage(startPage);
		pDto.setEndPage(endPage);
		return pDto;
	}
	
	@Override
	public List<Board> search(String searchText) {
		List<Board> result = paginationMapper.search(searchText);
		System.out.println("paginationMapper : >>>> " + result);
		return result;
	}
}
