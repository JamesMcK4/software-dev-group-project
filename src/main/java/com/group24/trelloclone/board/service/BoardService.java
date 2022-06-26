package com.group24.trelloclone.board.service;

import java.util.List;

import com.group24.trelloclone.board.model.BoardModel;

public interface BoardService {
    public BoardModel saveBoard(BoardModel board);
    public List<BoardModel> getBoards();
    public BoardModel getBoardById(Long boardId);
    public BoardModel deleteBoard(Long boardId);
    public boolean deleteAllBoards();
    public boolean updateBoardName(Long boardId, String name);
    public boolean updateBoardDescription(Long boardId, String description);
}
