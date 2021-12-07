package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import com.sp1.ctl.DeckService;

class Test_isFourCard
{
	DeckService deckService = new DeckService();
	
	public boolean isFourCard(List<Integer> cardNumList)
	{
		TreeMap<Integer, Integer> countNum = deckService.countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey(); // 가장 많이 중복된 횟수
		
		// isFourCard?
		return (countOverlap == 4) ? true : false;
	}
	
	@Test
	void test()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(1);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(2);
		list.add(4);
		
		System.out.println(isFourCard(list));
	}
	
}
