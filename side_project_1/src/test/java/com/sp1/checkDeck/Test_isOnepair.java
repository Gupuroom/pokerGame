package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sp1.service.DeckService;
import com.sp1.vo.CardVo;
import com.sp1.vo.ResultVo;


class Test_isOnepair
{
	DeckService deckService = new DeckService();
	
	public ResultVo isOnepair(List<Integer> cardNumList)
	{
		List<Integer> cloneList = new ArrayList<>(cardNumList); // 복사 후 사용
		// 숫자 중복 제거
		List<Integer> overlapRemove_cardNumList =  cloneList.stream().distinct().collect(Collectors.toList());
		TreeMap<Integer, Integer> countNum = deckService.countOverlapCard(cloneList);
		int countOverlap = countNum.lastEntry().getKey();
		int mostCardNum = countNum.lastEntry().getValue();
		
		// isOnepair?
		if(countOverlap == 2 && overlapRemove_cardNumList.size() == 6) // true
		{
			ResultVo resultVo = new ResultVo();
			resultVo.setMostCard(new CardVo(4,mostCardNum));
			resultVo.setResult("Onepair");
			resultVo.setResultCode(002); // TODO: 코드 결정해야함.
			return resultVo;
		}
				
		return null;
	}
	
	@Test
	void test()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(4);
		list.add(4);
		list.add(6);
		list.add(9);
		list.add(12);
		list.add(10);

		System.out.println(isOnepair(list));
	}
	
}
