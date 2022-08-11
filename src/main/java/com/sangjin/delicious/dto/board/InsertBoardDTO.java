package com.sangjin.delicious.dto.board;

import java.time.LocalDate;

import com.sangjin.delicious.domain.Article;

import lombok.Data;

@Data
public class InsertBoardDTO {

	private String title;
	private String content;
	
	public Article toEntity() {
		return Article.builder()
				.boardId(1)
				.createdDatetime(LocalDate.now())
				.isPinned(0)
				.viewCount(0)
				.title(title)
				.contentHtml(content)
				.contentString(content)
				.build();
	}
}
