package com.sangjin.delicious.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sangjin.delicious.domain.Article;
import com.sangjin.delicious.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {

	@Autowired
	BoardMapper boardMapper;
	
	@AfterEach
	public void cleenup() {
		boardMapper.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		//given
		String title = "테스트 제목";
		String content = "테스트 내용";
		int boardId = 1;
		boardMapper.insertPost(boardId, title, content);
		
		//when
		List<Article> articleList = boardMapper.boardListTest();
		
		//then
		Article article = articleList.get(0);
		assertThat(article.getTitle()).isEqualTo(title);
		assertThat(article.getContentHtml()).isEqualTo(content);
	}
	
	
	
}
