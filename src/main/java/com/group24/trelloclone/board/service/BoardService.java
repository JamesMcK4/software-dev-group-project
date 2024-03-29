package com.group24.trelloclone.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.exception.InvalidBoardIdException;
import com.group24.trelloclone.exception.InvalidTaskIdException;

@Service
public interface BoardService {
    public BoardModel saveBoard(BoardModel board);
    public List<BoardModel> getBoards();
    public List<BoardModel> getBoardsByID(List<Long> ids);
    public BoardModel getBoardById(Long boardId);
    public BoardModel deleteBoard(Long boardId);
    public boolean deleteAllBoards();
    public BoardModel addTask(Long boardId, Long taskId) throws InvalidTaskIdException, InvalidBoardIdException;
}
