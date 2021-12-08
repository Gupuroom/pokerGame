package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sp1.service.DeckService;
import com.sp1.vo.CardVo;
import com.sp1.vo.DeckVo;

class Test_isPlushStraight
{
	DeckService deckService = new DeckService();
	
	public boolean isPlushStraight(DeckVo deck)
	{
		List<Integer> cardPatternList = deck.getCardList().stream().map(card -> card.getPattern()).collect(Collectors.toList());// 패턴
		TreeMap<Integer, Integer> countPattern = deckService.countOverlapCard(cardPatternList);
		int countOverlap = countPattern.lastEntry().getKey();
		int pattern = countPattern.lastEntry().getValue();
		
		System.out.println("중복 개수 ( KEY ) : " + countOverlap + "  카드 패턴 ( VALUE ) : " + pattern);
		
		List<Integer> cardNumlist = new ArrayList<>();
		// isPlush?
		if (countOverlap >= 5)
		{
			for (CardVo card : deck.getCardList())
				if (card.getPattern() == pattern) 
					cardNumlist.add(card.getNum());
			
			// isStraight?
			return (deckService.isStraight(cardNumlist))? true : false;
		}
		
		return false;
	}
	
	@Test
	void test()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> list = new ArrayList<>();
		CardVo card_1 = new CardVo(10, 2);
		CardVo card_2 = new CardVo(8, 2);
		CardVo card_3 = new CardVo(11, 2);
		CardVo card_4 = new CardVo(9, 2);
		CardVo card_5 = new CardVo(12, 2);
		CardVo card_6 = new CardVo(13, 2);
		CardVo card_7 = new CardVo(3, 4);
		
		list.add(card_1);
		list.add(card_2);
		list.add(card_3);
		list.add(card_4);
		list.add(card_5);
		list.add(card_6);
		list.add(card_7);
		
		deck.setCardList(list);
		System.out.println(isPlushStraight(deck));
	}
	
}
