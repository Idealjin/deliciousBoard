package com.sangjin.delicious.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sangjin.delicious.dto.board.BoardList;
import com.sangjin.delicious.dto.board.BoardRetrieve;

public interface BoardMapper {

	int insertPost(
			@Param("boardId") int boardId,
			@Param("title") String title,
			@Param("content") String content);

	int insertPost2(
			@Param("nameKo") String nameKo);

	List<BoardList> boardList();

	int deletePost(
			@Param("articleId") int articleId);

	BoardRetrieve boardRetrieve(
			@Param("articleId") int articleId);

	int viewCountUpdate(
			@Param("viewCount") int viewCount,
			@Param("articleId") int articleId);

	int getViewCount(
			@Param("articleId") int articleId);

	int getBoardId();
	
	int getBoardId2(
			@Param("nameKo") String searchName);

	List<BoardList> searchBoardList(
			@Param("boardId") int boardId);


}
