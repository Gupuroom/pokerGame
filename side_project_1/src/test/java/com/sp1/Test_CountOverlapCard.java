package com.sp1;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sp1.ctl.CardVo;
import com.sp1.ctl.DeckService;
import com.sp1.ctl.DeckVo;
import com.sp1.ctl.PokerService;

/* 
 * TreeMap으로 구현한 이유
 * map의 경우 key값 중복이 안된다.
 * 고로 TreeMap.lastkey 값은 매개변수 List 값 중 가장 많이 중복된 숫자를 나타낸다.
 * TreeMap.lastkey가
 * 4일 경우 포카드 
 * 3일 경우 트리플 ( next value = 2 : 풀하우스 , not : 트리플 )
 * 2일 경우 원페어 ( two pair를 어떻게 찾을 지 생각해야 한다. ) onepair일 경우 숫자 List에서 onepair 값을 빼고 중복이 있는지를 검사하자.
 * 1일 경우 
 * 
 * 패턴은 5일때만 의미있다. ( 그때부터는 플러쉬라는 패가 생기기 때문 )
 */
// TODO: 이름 정해야 하는데..
class Test_CountOverlapCard
{
	
	@Test
	void test()
	{
		PokerService pokerService = new PokerService();
		DeckService deckService = new DeckService();
		
		// 랜덤 카드 7개 생성
		//List<CardVo> cardList = pokerService.makeTestDeck();
		
		DeckVo deck = new DeckVo();
		List<CardVo> list = new ArrayList<>();
		CardVo card_1 = new CardVo(10,1);
		CardVo card_2 = new CardVo(10,2);
		CardVo card_3 = new CardVo(10,3);
		CardVo card_4 = new CardVo(1,2);
		CardVo card_5 = new CardVo(1,3);
		CardVo card_6 = new CardVo(2,4);
		CardVo card_7 = new CardVo(4,4);
		
		list.add(card_1);
		list.add(card_2);
		list.add(card_3);
		list.add(card_4);
		list.add(card_5);
		list.add(card_6);
		list.add(card_7);
		
		//deck.setCardList(poker.makeTestDeck());
		deck.setCardList(list);
			
		System.out.println(deck.getCardList().toString());
		
		List<Integer> cardNumList = new ArrayList<>(); // 숫자 리스트
		List<Integer> cardPatternList = new ArrayList<>(); // 패턴 리스트
		
		deck.getCardList().stream().forEach(card -> {
			cardNumList.add(card.getNum());
			cardPatternList.add(card.getPattern());
		});
		
		System.out.println("cardNumList :: "+ cardNumList);
		System.out.println("cardPatternList ::" + cardPatternList);
		
		System.out.println("숫자 중복 값 리스트 :: "+ deckService.countOverlapCard(cardNumList).toString());
		System.out.println("패턴 중복 값 리스트 :: "+ deckService.countOverlapCard(cardPatternList).toString());
	}
}
