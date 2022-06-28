package com.group24.trelloclone.board.service;

import java.util.List;
import java.util.Optional;

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
		BoardModel deletedBoard = getBoardById(boardId);
		boardRepository.deleteById(boardId);
		if (getBoardById(boardId) == null){
			return deletedBoard;
		}
		return null;
	}

	@Override
	public boolean deleteAllBoards() {
		// TODO Auto-generated method stub
		boardRepository.deleteAll();
        if (boardRepository.count()==0){
            return true;
        }
        return false;
	}

	@Override
	public BoardModel getBoardById(Long boardId) {
		BoardModel board = null;
        Optional<BoardModel> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isPresent())
        {
            board = optionalBoard.get();
        }
        return board;
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
