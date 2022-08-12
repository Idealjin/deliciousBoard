package com.sangjin.delicious.service;

import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sangjin.delicious.domain.Article;
import com.sangjin.delicious.dto.BoardList;
import com.sangjin.delicious.dto.BoardRetrieve;
import com.sangjin.delicious.dto.InsertBoardDTO;
import com.sangjin.delicious.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {

	private final BoardMapper boardMapper;
	
	@Transactional
	public String insertPost(InsertBoardDTO insertBoardDto) { 
		String title = insertBoardDto.getTitle();
		String content = insertBoardDto.getContent();
		
		//가장 최근에 만들어진 게시판 번호를 가져온다.
		//게시판 여러개를 구현할때는 수정 필요
		int boardId= boardMapper.getBoardId();
		
		int insertResult = boardMapper.insertPost(boardId, title, content);
		
		if(insertResult == 0) {
			return "Insert Faild...";
		}
		return "Insert Success!";
	}

	
	public List<BoardList> boardList() {
		List<Article> boardList = boardMapper.boardList();
		return boardList.stream().map(BoardList::new).collect(Collectors.toList());
	}

	public String deletePost(int Id) {
		int deleteResult = boardMapper.deletePost(Id);
		if(deleteResult == 0) {
			return "Delete Faild...";
		}
		return "Delete Success!";
	}

	public List<BoardRetrieve> boardRetrieve(int articleId) {
	
		//viewCount를 +1 해준다.
		int viewCount = boardMapper.getViewCount(articleId);
		viewCount+=1;
		boardMapper.viewCountUpdate(viewCount, articleId);
		
		List<Article> boardDetail = boardMapper.boardRetrieve(articleId);			
		return boardDetail.stream().map(BoardRetrieve::new).collect(Collectors.toList());
		
	}

	public List<BoardList> searchBoardList(String searchName) {
		List<Article> searchResult = boardMapper.searchBoardList(searchName);
		return searchResult.stream().map(BoardList::new).collect(Collectors.toList());
	}

	public List<BoardList> searchBoardPeriod(String fromDate, String toDate) {
		List<Article> searchResult = boardMapper.searchBoardPeriod(fromDate, toDate);
		return searchResult.stream().map(BoardList::new).collect(Collectors.toList());
	}
	
}
