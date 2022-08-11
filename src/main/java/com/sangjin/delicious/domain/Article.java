package com.sangjin.delicious.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.Date;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="article_id")
	private int articleId;
	
	@Column(name="board_id")
	private int boardId;

	
	@Column(name="created_datetime")
	private Date createdDatetime;
	
	@Column(name="is_pinned")
	private int isPinned;

	@Column(name="view_count")
	private int viewCount;

	private String title;
		
	@Column(name="content_html")
	private String contentHtml;

	@Column(name="content_string")
	private String contentString;
	
	
	
}
