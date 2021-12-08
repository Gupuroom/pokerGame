package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sp1.service.DeckService;




class Test_isOnepair
{
	DeckService deckService = new DeckService();
	
	public boolean isOnepair(List<Integer> cardNumList)
	{
		// 숫자 중복 제거
		List<Integer> overlapRemove_cardNumList =  cardNumList.stream().distinct().collect(Collectors.toList());
		TreeMap<Integer, Integer> countNum = deckService.countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey();
		
		return (countOverlap == 2 && overlapRemove_cardNumList.size() == 6) ? true : false;
	}
	
	@Test
	void test()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(9);
		list.add(12);
		list.add(10);

		System.out.println(isOnepair(list));
	}
	
}
