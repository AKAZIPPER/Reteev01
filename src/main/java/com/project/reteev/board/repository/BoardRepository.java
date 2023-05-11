package com.project.reteev.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.project.reteev.board.entity.BoardEntity;


@EnableJpaRepositories
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
		
}
