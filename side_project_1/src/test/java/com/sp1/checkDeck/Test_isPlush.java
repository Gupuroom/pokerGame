package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sp1.service.DeckService;
import com.sp1.vo.CardVo;
import com.sp1.vo.DeckVo;

class Test_isPlush
{
	DeckService deckService = new DeckService();
	
	public boolean isPlush(List<Integer> cardPatternList)
	{
		TreeMap<Integer, Integer> countPattern = deckService.countOverlapCard(cardPatternList);
		int countOverlap = countPattern.lastEntry().getKey();
		
		// isPlush?
		return (countOverlap >= 5)? true : false;
	}
	
	@Test
	void test()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(2);
		
		System.out.println(isPlush(list));
	}
	
}
