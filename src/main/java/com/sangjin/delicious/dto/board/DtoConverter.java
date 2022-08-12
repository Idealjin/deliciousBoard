package com.sangjin.delicious.dto.board;

import org.springframework.stereotype.Component;

import com.sangjin.delicious.domain.Article;

@Component
public class DtoConverter {
  public BoardList toBoardList(Article article) {
    return new BoardList(article.getArticleId(), 
    					article.getTitle(), 
    					article.getIsPinned(),
    					article.getViewCount(), 
    					article.getCreatedDatetime());
  }

public BoardList toBoardList2(BoardList boardList) {
	return new BoardList(boardList.getArticleId(), 
			boardList.getTitle(), 
			boardList.getIsPinned(),
			boardList.getViewCount(), 
			boardList.getCreatedDatetime());
}
}
