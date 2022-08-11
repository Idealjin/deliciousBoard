package com.sangjin.delicious.controller.board;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sangjin.delicious.common.ApiResponse;
import com.sangjin.delicious.common.ApiStatus;
import com.sangjin.delicious.dto.board.InsertBoardDTO;
import com.sangjin.delicious.service.board.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@PostMapping()				//�Խù� ����
	public ApiResponse insertPost( 		       
			@ModelAttribute InsertBoardDTO insertBoardDto) {
		return new ApiResponse(ApiStatus.SUCCESS, boardService.insertPost(insertBoardDto));
	}
	
	@GetMapping("/detail")		//�Խù� �� ��ȸ
	public ApiResponse boardRetrieve (
			@RequestParam(value = "id", required = true) int articleId) {
	return new ApiResponse(ApiStatus.SUCCESS, boardService.boardRetrieve(articleId));
	}
	
	
	@GetMapping()				//�Խù� ��� ��ȸ
	public ApiResponse BoardList() {			
	return new ApiResponse(ApiStatus.SUCCESS, boardService.boardList());
	}
	
	@DeleteMapping()			//�Խù� ����
	public ApiResponse deletePost(
			@RequestParam(value = "id", required = true) int articleId) {
		return new ApiResponse(ApiStatus.SUCCESS, boardService.deletePost(articleId));
	}
	
	@GetMapping("/search")		//�Խù� �˻�
	public ApiResponse searchBoardList(
			@RequestParam(value = "searchName", required = true) String searchName) {
	return new ApiResponse(ApiStatus.SUCCESS, boardService.searchBoardList(searchName));
	}
	
	@GetMapping("/search/period")		//�Խù� �Ⱓ �˻�
	public ApiResponse searchBoardPeriod(
			@RequestParam(value = "fromDate", required = true) String fromDate,
			@RequestParam(value = "toDate", required = true) String toDate) {
	return new ApiResponse(ApiStatus.SUCCESS, boardService.searchBoardPeriod(fromDate, toDate));
	}
}
