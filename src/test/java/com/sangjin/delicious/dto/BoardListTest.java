package com.sangjin.delicious.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sangjin.delicious.dto.BoardList;
import org.junit.jupiter.api.Test;

public class BoardListTest {

	@Test
	public void BoardList_DTO_테스트() throws ParseException {
		//given
		int articleId = 1;
		String title = "test";
		int viewCount = 1;
		int isPinned = 0;
		
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date createdDatetime = dtFormat.parse("2022-08-10");
		
		//when
		BoardList dto = new BoardList(articleId, title, viewCount, isPinned, createdDatetime);
		
		//then
		assertThat(dto.getArticleId()).isEqualTo(articleId);
		assertThat(dto.getTitle()).isEqualTo(title);
		assertThat(dto.getViewCount()).isEqualTo(viewCount);
		assertThat(dto.getIsPinned()).isEqualTo(isPinned);
		assertThat(dto.getCreatedDatetime()).isEqualTo(createdDatetime);
	}
	
}
