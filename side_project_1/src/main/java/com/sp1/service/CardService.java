package com.sp1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sp1.vo.CardVo;

public class CardService
{
	
	// 초기 카드 세팅
	public List<CardVo> setStartCardList()
	{
		List<CardVo> startCardList  = new ArrayList<CardVo>();
		
		for(int i = 1; i <= 4; i++) // 패턴
			for(int j = 1; j <= 13; j++) // 숫자
				startCardList.add(new CardVo(i,j));
		
		return startCardList;
	}
	
	// Random Card
	public CardVo drawCard(List<CardVo> startCardList)
	{
		int drawNum = new Random().nextInt(startCardList.size())-1; // 시작덱에서 뽑을 카드순서 random
		CardVo card = startCardList.get(drawNum); // 반환할 카드
		
		return card; 
	}
	
	

}
