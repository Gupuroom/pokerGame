package com.sp1.compareDeck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sp1.service.CardService;
import com.sp1.vo.CardVo;

class Test_CompareDeck
{
	CardService cardService = new CardService();
	
	@Test
	void test()
	{
		List<CardVo> startCardDeck = cardService.setStartCardList();
		System.out.println("cardDeck : " + startCardDeck.toString());
		
		List<CardVo> player1 = new ArrayList<CardVo>();
		List<CardVo> player2 = new ArrayList<CardVo>();
		
		for (int i = 0; i < 14; i++)
		{
			CardVo card = cardService.drawCard(startCardDeck);
			if (i % 2 == 0) // 짝수
			{
				player1.add(card);
				startCardDeck.remove(card);
			}
			else // 홀수
			{
				player2.add(card);
				startCardDeck.remove(card);
			}
		}
		
		assertEquals(52 - 14, startCardDeck.size()); // draw는 잘됨
		System.out.println("player 1 : " + player1.toString());
		System.out.println("player 2 : " + player2.toString());
	}
}
