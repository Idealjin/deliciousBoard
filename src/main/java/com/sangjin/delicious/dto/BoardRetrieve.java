package com.sangjin.delicious.dto;

import java.util.Date;

import com.sangjin.delicious.domain.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardRetrieve {
	private int articleId;
	private String title;
	private String contentHtml;
	private int viewCount;
	private int isPinned;
	private Date createdDatetime;
	
	public BoardRetrieve(Article article) {
		articleId = article.getArticleId();
		title = article.getTitle();
		contentHtml = article.getContentHtml();
		viewCount = article.getViewCount();
		isPinned = article.getIsPinned();
		createdDatetime = article.getCreatedDatetime();
	}
}
