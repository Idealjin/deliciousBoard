package com.sangjin.delicious.dto.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardRetrieve {
	private int articleId;
	private String title;
	private String contentHtml;
	private int viewCount;
	private int isPinned;
	private Date createdDatetime;
}
