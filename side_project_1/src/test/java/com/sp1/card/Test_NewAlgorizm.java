package com.sp1.card;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sp1.service.CardService;
import com.sp1.service.TestService;
import com.sp1.vo.CardPattern;
import com.sp1.vo.CardVo;
import com.sp1.vo.DeckVo;

class Test_NewAlgorizm
{
	TestService testService = new TestService();
	CardService cardService = new CardService();
	
	public void newTest(DeckVo deck)
	{
		List<CardVo> cardList = deck.getCardList();
		List<Integer> numList = new ArrayList<Integer>(); // 숫자 중복 값 표시 리스트
		List<Integer> patternList = new ArrayList<Integer>(); // 패턴 중복 값 표시 리스트
		
		// numList 초기화
		for (int i = 0; i < 13; i++)
			numList.add(0);
		
		// patternList 초기화
		for (int i = 0; i < 4; i++)
			patternList.add(0);
		
		//System.out.println("numList : " + numList.toString());
		//System.out.println("patternList : " + patternList.toString());
		
		// 카드 리스트 정리
		for (CardVo card : cardList)
		{
			numList.set(card.getNum() - 1, numList.get(card.getNum() - 1) + 1);
			patternList.set(card.getPattern().ordinal(), patternList.get(card.getPattern().ordinal()) + 1);
		}
		
		//System.out.println("numList : " + numList.toString());
		//System.out.println("patternList : " + patternList.toString());
		
		int firstKeyCard_Num = 0;
		CardPattern firstKeyCard_Pattern = CardPattern.HEART;
		int firstKeyCard_Num_Overlap = 0;
		
		int secondKeyCard_Num = 0;
		CardPattern secondKeyCard_Pattern = CardPattern.HEART;
		int secondKeyCard_Num_Overlap = 0;
		
		for (int i = 0; i < 13; i++)
			if (numList.get(i) >= firstKeyCard_Num_Overlap)
			{
				secondKeyCard_Num = firstKeyCard_Num;
				secondKeyCard_Num_Overlap = firstKeyCard_Num_Overlap;
				
				firstKeyCard_Num = i + 1;
				firstKeyCard_Num_Overlap = numList.get(i);
			}
		
		for (CardVo card : cardList)
		{
			if (card.getNum() == firstKeyCard_Num && card.getPattern().ordinal() > firstKeyCard_Pattern.ordinal()) firstKeyCard_Pattern = card.getPattern();
			if (card.getNum() == secondKeyCard_Num && card.getPattern().ordinal() > secondKeyCard_Pattern.ordinal()) secondKeyCard_Pattern = card.getPattern();
		}
		
		//System.out.println("firstKeyCard 숫자: " + firstKeyCard_Num + " 패턴: " + firstKeyCard_Pattern + " 중복된 수: " + firstKeyCard_Num_Overlap);
		//System.out.println("secondKeyCard 숫자: " + secondKeyCard_Num + " 패턴: " + firstKeyCard_Pattern + " 중복된 수: " + secondKeyCard_Num_Overlap);
		
		int keyCard_Pattern = 0;
		int keyCard_Pattern_Overlap = 0;
		
		for (int i = 0; i < 4; i++)
		{
			if (patternList.get(i) >= keyCard_Pattern_Overlap)
			{
				keyCard_Pattern = i + 1;
				keyCard_Pattern_Overlap = patternList.get(i);
			}
		}
		
		//System.out.println("제일 중복 많이 된 패턴 : " + keyCard_Pattern + " 중복된 수 : " + keyCard_Pattern_Overlap);
		
		int straightCheckNum = 0;
		
		for (int i = 0; i < 13; i++)
		{
			if (numList.get(i) != 0) 
				straightCheckNum++;
			
			if (i == 12 && straightCheckNum == 4 && numList.get(0) != 0) // [10,J,Q,K,A]
				straightCheckNum++;
			
			if (numList.get(i) == 0 && straightCheckNum < 5) 
				straightCheckNum = 0;
		}
		
		// System.out.println("straight?? : " + straightCheckNum); // 5이상이면 Straight
		
		// TODO 2. isFourcard?
		if (firstKeyCard_Num_Overlap == 4)
			System.out.println(firstKeyCard_Num + " 포카드");
		// TODO 3. isPullHouse?
		else if (firstKeyCard_Num_Overlap == 3 && secondKeyCard_Num_Overlap >= 2)
			System.out.println(firstKeyCard_Num + " " + secondKeyCard_Num + " 풀하우스");
		// TODO 4. isPlush?
		else if (keyCard_Pattern_Overlap == 5)
			System.out.println(keyCard_Pattern + " 플러쉬");
		// TODO 5. isStraight? 백스트레이트 , 탑스트레이트 어떻게 할건지 생각해봐야함~
		else if (straightCheckNum >= 5)
		{
			// TODO 5-1. isPlushStraight?
			// if()
			
			System.out.println(firstKeyCard_Num + " 스트레이트");
		}
		// TODO 6. isTriple?
		else if (firstKeyCard_Num_Overlap == 3)
			System.out.println(firstKeyCard_Num + " 트리플");
		// TODO 7. isTwopair?
		else if (firstKeyCard_Num_Overlap == 2 && secondKeyCard_Num_Overlap == 2)
			System.out.println(firstKeyCard_Num + " " + secondKeyCard_Num + " 투페어");
		// TODO 8. isOnepair?
		else if (firstKeyCard_Num_Overlap == 2 && secondKeyCard_Num_Overlap <= 1)
			System.out.println(firstKeyCard_Num + " 원페어");
		// TODO 9. isTop?
		else
			System.out.println(firstKeyCard_Num + firstKeyCard_Pattern.name() + " 탑");
	}
	
	@Test
	void test()
	{
		List<CardVo> startCardList = cardService.setStartCardList(); // 시작 카드 묶음 설정
		// DeckVo deck = testService.makeTopTestDeck();
		
		for(int j = 0 ; j < 2;j++) {
		List<CardVo> testList = new ArrayList<CardVo>();
		for(int i=0; i < 7;i++) {
		CardVo card = cardService.drawCard(startCardList); //
		testList.add(card);
		startCardList.remove(card);
		}
		
		DeckVo deck = new DeckVo();
		deck.setCardList(testList);
		newTest(deck);
		}
	}
	
}
