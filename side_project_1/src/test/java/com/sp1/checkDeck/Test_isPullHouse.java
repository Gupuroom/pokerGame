package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sp1.ctl.CardVo;
import com.sp1.ctl.DeckService;
import com.sp1.ctl.DeckVo;

class Test_isPullHouse
{
	DeckService deckService = new DeckService();
	
	public boolean isPullHouse(List<Integer> cardNumList)
	{
		// 숫자 중복 제거
		List<Integer> overlapRemove_cardNumList =  cardNumList.stream().distinct().collect(Collectors.toList());
		TreeMap<Integer, Integer> countNum = deckService.countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey();
		
		if(countOverlap == 3)
		{
			if(overlapRemove_cardNumList.size() == 4 || overlapRemove_cardNumList.size() == 3)
				return true;
			else
				return false; // 트리플
		}
		
		return false;
	}
	
	@Test
	void test()
	{
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(2);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(2);
		list.add(10);

		System.out.println(isPullHouse(list));
	}
	
}
