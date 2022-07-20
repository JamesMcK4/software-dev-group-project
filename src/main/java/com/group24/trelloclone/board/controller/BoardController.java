package com.group24.trelloclone.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.group24.trelloclone.utils.Response.*;
import static io.github.handsomecoder.utils.ObjectUtils.isNull;
import static io.github.handsomecoder.utils.StringUtils.isEmpty;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.status;

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

    @GetMapping("/get_board/{id}")
    public BoardModel getWorkspaceById(@PathVariable("id") Long boardId)
    {
        BoardModel workspace =  boardService.getBoardById(boardId);
        return workspace;
    }

    @PutMapping("add-task/{boardId}/{taskId}")
    public ResponseEntity<Map<String, Object>> updateTaskStatus(@PathVariable("boardId") String boardId,
        @PathVariable("taskId") String taskId) {
        if (isEmpty(taskId)) {
            return status(HttpStatus.BAD_REQUEST).body(singletonMap(MESSAGE.getValue(), "Missing required field: [taskId]"));
        }

        if (isEmpty(boardId)) {
            return status(HttpStatus.BAD_REQUEST).body(singletonMap(MESSAGE.getValue(), "Missing required field: [boardId]"));
        }

        BoardModel board;

        try{
            board = boardService.addTask(Long.parseLong(boardId), Long.parseLong(taskId));
        }
        catch (Exception e){
            System.out.println(e);
            return status(HttpStatus.BAD_REQUEST).body(singletonMap(ERROR.getValue(), e.getMessage()));
        }

        return status(HttpStatus.OK).body(singletonMap(OBJECT.getValue(), board));
    }

    @DeleteMapping("/delete_all_boards")
    public boolean deleteAllUsers()
    {
        return boardService.deleteAllBoards();
    }

}
