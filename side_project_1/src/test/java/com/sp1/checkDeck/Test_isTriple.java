package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sp1.ctl.DeckService;




class Test_isTriple
{
	DeckService deckService = new DeckService();
	
	public boolean isTriple(List<Integer> cardNumList)
	{
		// 숫자 중복 제거
		List<Integer> overlapRemove_cardNumList =  cardNumList.stream().distinct().collect(Collectors.toList());
		TreeMap<Integer, Integer> countNum = deckService.countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey();
		
		return (countOverlap == 3 && overlapRemove_cardNumList.size() == 5) ? true : false;
	}
	
	@Test
	void test()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(12);
		list.add(10);

		System.out.println(isTriple(list));
	}
	
}
