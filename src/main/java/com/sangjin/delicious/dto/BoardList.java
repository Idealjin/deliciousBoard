package com.sangjin.delicious.dto;

import java.util.Date;

import com.sangjin.delicious.domain.Article;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardList {
	private int articleId;
	private String title;
	private int viewCount;
	private int isPinned;
	private Date createdDatetime;
	
	public BoardList(Article article) {
		articleId = article.getArticleId();
		title = article.getTitle();
		viewCount = article.getViewCount();
		isPinned = article.getIsPinned();
		createdDatetime = article.getCreatedDatetime();
	}
	
}
