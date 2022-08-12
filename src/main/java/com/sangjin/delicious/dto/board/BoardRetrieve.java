package com.sangjin.delicious.dto.board;

import java.util.Date;

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
}
