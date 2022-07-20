package com.group24.trelloclone.board.controller;

import java.util.List;
import java.util.Map;

import com.group24.trelloclone.workspace.model.WorkspaceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group24.trelloclone.board.model.BoardModel;
import com.group24.trelloclone.board.service.BoardService;

import static com.group24.trelloclone.utils.ApplicationConstant.OBJECT;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.status;

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

    @DeleteMapping("/delete_all_boards")
    public boolean deleteAllUsers()
    {
        return boardService.deleteAllBoards();
    }

    @PutMapping("/add_task/{board_id}/{task_id}")
    public ResponseEntity<Map<String, Object>> addTask(@PathVariable("board_id") Long boardId, @PathVariable("task_id") Long taskId)
    {
        BoardModel board;
        try{
            board = boardService.addTask(boardId, taskId);
        }
        catch(Exception e){
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(OBJECT, null));
        }
        return status(HttpStatus.OK).body(singletonMap(OBJECT, board));
    }

}
