package com.sp1.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sp1.service.CardService;
import com.sp1.vo.CardVo;

class Test_DrawCardTest
{
	CardService cardService = new CardService();
	
	static List<CardVo> startCardList = null;
	
	@Test
	void test()
	{
		startCardList = cardService.setStartCardList(); // 시작 카드 묶음 설정

		for(int i=0; i < 7;i++) {
		CardVo card = cardService.drawCard(startCardList); //
		System.out.println(card);
		startCardList.remove(card);
		}
		
		
		System.out.println("뽑은 후 카드 개수 : " + startCardList.size());
		
		assertEquals(45, startCardList.size()); 
	}
	
}
