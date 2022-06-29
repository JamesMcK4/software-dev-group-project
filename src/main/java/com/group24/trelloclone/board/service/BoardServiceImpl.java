package com.group24.trelloclone.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
	BoardRepository boardRepository;

	@Override
	public BoardModel saveBoard(BoardModel board) {
        return boardRepository.save(board);
	}

	@Override
	public BoardModel deleteBoard(Long boardId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAllBoards() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BoardModel getBoardById(Long boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBoardName(Long boardId, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBoardDescription(Long boardId, String description) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardModel> getBoards() {
		return boardRepository.findAll();
	}

	@Override
	public List<BoardModel> getBoardsByID(List<Long> ids) {
		return boardRepository.findAllById(ids);
	}
}
