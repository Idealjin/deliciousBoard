package com.sangjin.delicious.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sangjin.delicious.common.ApiResponse;
import com.sangjin.delicious.common.ApiStatus;
import com.sangjin.delicious.dto.InsertBoardDTO;
import com.sangjin.delicious.service.BoardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class BoardController {
	
	private final BoardService boardService;
	
	@PostMapping()		//게시글 생성
	public ApiResponse insertPost( 		       
			@ModelAttribute InsertBoardDTO insertBoardDto) {
		return new ApiResponse(ApiStatus.SUCCESS, boardService.insertPost(insertBoardDto));
	}
	
	@GetMapping("/detail")		//게시글 상세보기
	public ApiResponse boardRetrieve (
			@RequestParam(value = "id", required = true) int Id) {
	return new ApiResponse(ApiStatus.SUCCESS, boardService.boardRetrieve(Id));
	}
	
	
	@GetMapping()				//게시글 목록 조회
	public ApiResponse BoardList() {			
	return new ApiResponse(ApiStatus.SUCCESS, boardService.boardList());
	}
	
	@DeleteMapping()			//게시글 삭제
	public ApiResponse deletePost(
			@RequestParam(value = "id", required = true) int Id) {
		return new ApiResponse(ApiStatus.SUCCESS, boardService.deletePost(Id));
	}
	
	@GetMapping("/search")		//게시글 검색
	public ApiResponse searchBoardList(
			@RequestParam(value = "searchName", required = true) String searchName) {
	return new ApiResponse(ApiStatus.SUCCESS, boardService.searchBoardList(searchName));
	}
	
	@GetMapping("/search/period")		//게시글 기간으로 검색
	public ApiResponse searchBoardPeriod(
			@RequestParam(value = "fromDate", required = true) String fromDate,
			@RequestParam(value = "toDate", required = true) String toDate) {
	return new ApiResponse(ApiStatus.SUCCESS, boardService.searchBoardPeriod(fromDate, toDate));
	}

}
