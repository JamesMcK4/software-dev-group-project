package com.group24.trelloclone.board.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.board.repository.BoardRepository;
import com.group24.trelloclone.exception.InvalidBoardIdException;
import com.group24.trelloclone.exception.InvalidTaskIdException;
import com.group24.trelloclone.task.model.TaskModel;
import com.group24.trelloclone.task.service.TaskService;

import static io.github.handsomecoder.utils.ObjectUtils.isNull;


@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
	BoardRepository boardRepository;

	@Autowired
	TaskService taskService;

	@Override
	public BoardModel saveBoard(BoardModel board) {
        return boardRepository.save(board);
	}

	@Override
	public BoardModel deleteBoard(Long boardId) {
		BoardModel deletedBoard = getBoardByID(boardId);
		boardRepository.deleteById(boardId);
		if (getBoardByID(boardId) == null){
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
	public BoardModel getBoardByID(Long boardId) {
		BoardModel board = null;
        Optional<BoardModel> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isPresent())
        {
            board = optionalBoard.get();
        }
        return board;

	}

	@Transactional
	@Override
	public boolean updateBoardName(Long boardId, String name) {
		return false;
	}

	@Transactional
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

	@Transactional
	@Override
	public BoardModel addTask(Long boardId, Long taskId) throws InvalidTaskIdException, InvalidBoardIdException{
		BoardModel board = getBoardById(boardId);
		TaskModel task = taskService.getTaskById(taskId);

		if (isNull(board)) {
			throw new InvalidBoardIdException();
		}

		if (isNull(task)) {
			throw new InvalidTaskIdException();
		}

		board.getTasks().add(task);

		return boardRepository.save(board);
	}
}
