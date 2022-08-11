package com.sangjin.delicious.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.sangjin.delicious.dto.board.BoardList;

public class BoardListTest {

	@Test
	public void BoardList_DTO_Å×½ºÆ®() throws ParseException {
		//given
		int articleId = 1;
		String title = "test";
		int viewCount = 1;
		int isPinned = 0;
		
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date createdDateTime = dtFormat.parse("2022-08-10");
		
		//when
		BoardList dto = new BoardList(articleId, title, viewCount, isPinned, createdDateTime);
		
		//then
		assertThat(dto.getArticleId()).isEqualTo(articleId);
		assertThat(dto.getTitle()).isEqualTo(title);
		assertThat(dto.getViewCount()).isEqualTo(viewCount);
		assertThat(dto.getIsPinned()).isEqualTo(isPinned);
		assertThat(dto.getCreatedDateTime()).isEqualTo(createdDateTime);
	}
	
}
