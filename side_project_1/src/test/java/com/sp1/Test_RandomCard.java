package com.sp1;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sp1.ctl.CardVo;
import com.sp1.ctl.PokerService;

class Test_RandomCard
{
	
	@Test
	void test()
	{
		PokerService poker = new PokerService();
		poker.setStartCardList();
		List<CardVo> cardList  = poker.makeTestDeck();
		
		cardList.stream().forEach(card -> System.out.println(card.toString()));
	
	}
}
