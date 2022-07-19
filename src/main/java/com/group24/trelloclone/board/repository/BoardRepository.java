package com.group24.trelloclone.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group24.trelloclone.board.model.BoardModel;

@Repository 
public interface BoardRepository extends JpaRepository<BoardModel, Long>

{
    
}
