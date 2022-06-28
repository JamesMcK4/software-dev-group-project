package com.group24.trelloclone.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.board.service.BoardService;

@CrossOrigin()
@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
	private BoardService boardService;
	
	@PostMapping(path = "/save_board", consumes = "application/json", produces = "application/json")
	public BoardModel saveBoard(@RequestBody BoardModel board) {
		return boardService.saveBoard(board);
	}

    @DeleteMapping("/delete_board/{id}")
    public BoardModel deleteBoard(@PathVariable("id") Long boardId)
    {
        return boardService.deleteBoard(boardId);
    }

	@GetMapping(path = "/get_all_boards")
    public List<BoardModel> getBoards(){
        return boardService.getBoards();
    }

	@GetMapping(path = "/get_boards_by_ids")
    public List<BoardModel> getBoardsByID(@RequestParam("ids") List<Long> ids){
        return boardService.getBoardsByID(ids);
    }

    @DeleteMapping("/delete_all_boards")
    public boolean deleteAllUsers()
    {
        return boardService.deleteAllBoards();
    }
}
