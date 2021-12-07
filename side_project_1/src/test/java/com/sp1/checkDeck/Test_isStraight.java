package com.sp1.checkDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Test_isStraight
{
	public boolean isStraight(List<Integer> cardNumList)
	{
		List<Integer> sortList = cardNumList.stream().sorted().collect(Collectors.toList()); // 정렬
		int count = 0;
		for (int i = 0; i < sortList.size() - 1; i++)
			if (sortList.get(i) + 1 == sortList.get(i + 1)) count++;
			else if(sortList.get(i) + 1 != sortList.get(i + 1) && count != 4) count = 0;
			else continue;
		
		return (count >= 4)? true : false;
	}
	
	@Test
	void test()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(1);
		list.add(5);
		list.add(8);
		list.add(7);
		list.add(2);
		list.add(4);
		
		System.out.println(isStraight(list));
		
	}
	
}
