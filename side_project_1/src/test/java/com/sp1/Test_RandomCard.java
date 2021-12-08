package com.sp1;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sp1.service.CardService;
import com.sp1.vo.CardVo;

class Test_RandomCard
{
	
	@Test
	void test()
	{
		CardService poker = new CardService();
		poker.setStartCardList();
		List<CardVo> cardList  = poker.makeTestDeck();
		
		cardList.stream().forEach(card -> System.out.println(card.toString()));
	
	}
}
