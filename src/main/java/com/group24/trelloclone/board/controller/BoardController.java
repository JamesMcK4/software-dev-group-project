package com.group24.trelloclone.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
	private BoardService boardsService;
	
	@PostMapping(path = "/add_board", consumes = "application/json", produces = "application/json")
	public BoardModel addBoards(@RequestBody BoardModel board) {
		return boardsService.saveBoard(board);
	}

}
