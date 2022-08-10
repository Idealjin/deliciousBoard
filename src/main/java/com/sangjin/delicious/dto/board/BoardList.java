package com.sangjin.delicious.dto.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardList {
	private int articleId;
	private String title;
	private int viewCount;
	private int isPinned;
	private Date createdDateTime;
}
