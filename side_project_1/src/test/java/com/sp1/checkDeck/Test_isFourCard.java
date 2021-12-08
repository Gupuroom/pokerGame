package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import com.sp1.service.DeckService;
import com.sp1.vo.CardVo;
import com.sp1.vo.ResultVo;

// check FourCard
class Test_isFourCard
{
	DeckService deckService = new DeckService();
	
	public ResultVo isFourCard(List<Integer> cardNumList)
	{
		List<Integer> cloneList = new ArrayList<>(cardNumList); // 복사 후 사용
		TreeMap<Integer, Integer> countNum = deckService.countOverlapCard(cloneList);
		int countOverlap = countNum.lastEntry().getKey(); // 가장 많이 중복된 횟수
		int mostCardNum = countNum.lastEntry().getValue();
		
		// isFourCard?
		if(countOverlap == 4) // true
		{
			ResultVo resultVo = new ResultVo();
			resultVo.setMostCard(new CardVo(4,mostCardNum));
			resultVo.setResult("FourCard");
			resultVo.setResultCode(002); // TODO: 코드 결정해야함.
			return resultVo;
		}
		
		return null;
	}
	
	@Test
	void test()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(6);
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(4);
		
		ResultVo result = isFourCard(list);
		System.out.println(result.getMostCard().getNum()+" "+result.getResult()+"입니다.");
	}
}
