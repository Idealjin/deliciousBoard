package com.sangjin.delicious.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ArticleTest {

	@Id
	@GeneratedValue	
	@Column(name = "article_id")
	private Long articleId;	
	@Column(name = "board_id")
	private int boardId;
	@Column(name = "created_datetime")
	private LocalDate createdDatetime;
	@Column(name = "is_pinned")
	private int isPinned;
	@Column(name = "view_count")
	private int viewCount;
	
	private String title;
	
	 @Column(name = "content_html", columnDefinition = "TEXT", nullable = false)
	private String contentHtml;
	 
	 @Column(name = "content_string")
	private String contentString;
	
	@Builder
	public ArticleTest(int boardId, LocalDate createdDatetime, int isPinned,int viewCount,
				String title, String contentHtml, String contentString) {
		this.boardId = boardId;
		this.createdDatetime = createdDatetime;
		this.isPinned = isPinned;
		this.viewCount = viewCount;
		this.title = title;
		this.contentHtml = contentHtml;
		this.contentString = contentString;
	}
}
