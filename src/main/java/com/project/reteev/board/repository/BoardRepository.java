package com.project.reteev.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.reteev.model.Board;


public interface BoardRepository extends JpaRepository<Board, Long>{
	
	Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}