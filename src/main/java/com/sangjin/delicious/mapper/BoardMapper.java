package com.sangjin.delicious.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sangjin.delicious.domain.Article;
import com.sangjin.delicious.dto.BoardList;
import com.sangjin.delicious.dto.BoardRetrieve;

public interface BoardMapper{

	int insertPost(
			@Param("boardId") int boardId, 
			@Param("title") String title,
			@Param("content") String content);

	int insertPost2(
			@Param("nameKo") String nameKo);

	List<Article> boardList();
	
	int deletePost(
			@Param("articleId") int articleId);

	List<Article> boardRetrieve(
			@Param("articleId") int articleId);

	int viewCountUpdate(
			@Param("viewCount") int viewCount,
			@Param("articleId") int articleId);

	int getViewCount(
			@Param("articleId") int articleId);

	int getBoardId();
	
	List<Article> searchBoardList(
			@Param("searchName") String searchName);

	List<Article> searchBoardPeriod(
			@Param("fromDate") String fromDate, 
			@Param("toDate") String toDate);

	void deleteAll();

	List<Article> boardListTest();
	
}
