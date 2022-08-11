package com.sangjin.delicious.service.board;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sangjin.delicious.dto.board.BoardList;
import com.sangjin.delicious.dto.board.BoardRetrieve;
import com.sangjin.delicious.dto.board.InsertBoardDTO;
import com.sangjin.delicious.mapper.BoardMapper;

@Service
public class BoardService {

	private final BoardMapper boardMapper;
	
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	public Map<String, Integer> insertPost(InsertBoardDTO insertBoardDto) {
		
		Map<String, Integer> result = new HashMap<>();
		
		String title = insertBoardDto.getTitle();
		String content = insertBoardDto.getContent();
		
		int boardId= boardMapper.getBoardId();
		
		int insertResult = boardMapper.insertPost(boardId, title, content);
		
		result.put("insertResult", insertResult);
		
		return result;
	}

	public Map<String, List<BoardList>> boardList() {
		
		Map<String, List<BoardList>> result = new HashMap<>();
		
		List<BoardList> boardList = boardMapper.boardList();
		
		result.put("boardList", boardList);
		
		return result;
	}

	public Map<String, Integer> deletePost(int articleId) {
		
		Map<String, Integer> result = new HashMap<>();
		
		int deleteResult = boardMapper.deletePost(articleId);
		
		result.put("deleteResult", deleteResult);
		
		return result;
	}

	public Map<String, BoardRetrieve> boardRetrieve(int articleId) {
		
		Map<String, BoardRetrieve> result = new HashMap<>();
		
		
		int viewCount = boardMapper.getViewCount(articleId);
		viewCount+=1;
		int viewCountUpdateResult = boardMapper.viewCountUpdate(viewCount, articleId);
			
		if(viewCountUpdateResult != 0) {
			BoardRetrieve boardDetail = boardMapper.boardRetrieve(articleId);			
			result.put("boardDetail", boardDetail);
		}
		
		return result;
	}

	public Map<String, List<BoardList>> searchBoardList(String searchName) {
		
		Map<String, List<BoardList>> result = new HashMap<>();
		
		List<BoardList> searchResult = boardMapper.searchBoardList(searchName);
		
		result.put("searchResult", searchResult);
		
		return result;
	}

	public Object searchBoardPeriod(String fromDate, String toDate) {
		
		Map<String, List<BoardList>> result = new HashMap<>();
		
		List<BoardList> searchResult = boardMapper.searchBoardPeriod(fromDate, toDate);
		
		result.put("searchResult", searchResult);
		
		return result;
	}

}
