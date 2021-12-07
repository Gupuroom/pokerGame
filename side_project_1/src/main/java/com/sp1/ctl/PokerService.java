package com.sp1.ctl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokerService
{
	static List<CardVo> startCardList  = new ArrayList<CardVo>();
	
	public void setStartCardList()
	{
		for(int i = 1; i <= 4; i++) // 패턴
			for(int j = 1; j <= 13; j++) // 숫자
			{
				CardVo card = new CardVo(j,i);
				startCardList.add(card);
			}
		
	}
	// Random Card
	public CardVo makeRandomCard()
	{
		Random random = new Random();
		int drawNum = random.nextInt(startCardList.size())-1; // 시작덱에서 뽑을 카드순서 random
		CardVo card = startCardList.get(drawNum); // 반환할 카드
		startCardList.remove(drawNum); // 반환한 카드 List에서 삭제
		
		return card; 
	}
	
	// make test Deck
	public List<CardVo> makeTestDeck()
	{
		System.out.println("초기덱 남은 카드 개수 : "+startCardList.size());
		List<CardVo> cardList  = new ArrayList<CardVo>();
		for (int i = 0; i < 7; i++)
		{
			cardList.add(makeRandomCard());
		}
		
		return cardList; 
	}

}
