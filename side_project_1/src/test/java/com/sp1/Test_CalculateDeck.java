package com.sp1;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sp1.service.DeckService;
import com.sp1.service.CardService;
import com.sp1.vo.DeckVo;

//숫자 리스트에서 중복제거했을 때 
//원페어면 : -1
//투페어면 : -2
//트리플 : -2
//풀하우스= 트리플 + 원페어 : -3
//포카드 = 포카드 : -3
//풀하우스= 트리플 + 트리플 : -4
//포카드 = 포카드+ 원페어 : -4
//포카드 = 포카드+ 트리플 : -5
class Test_CalculateDeck
{
	CardService pokerService = new CardService();
	DeckService deckService = new DeckService();
	
	// 덱 계산
	public String calculateDeck(DeckVo deck)
	{
		List<Integer> cardNumList = deck.getCardList().stream().map(card->card.getNum()).collect(Collectors.toList()); // 숫자
		List<Integer> cardPatternList = deck.getCardList().stream().map(card->card.getPattern()).collect(Collectors.toList()); // 패턴
		
		// 숫자 중복 제거
		// List<Integer> overlapRemove_cardNumList =  cardNumList.stream().distinct().collect(Collectors.toList());
		// System.out.println("[중복 제거] cardNumList :: "+ overlapRemove_cardNumList);
//		System.out.println("cardNumList :: "+ cardNumList);
//		System.out.println("cardPatternList ::" + cardPatternList);
		
		// TODO 1. isPlushStraight? Good
		if(deckService.isPlushStraight(deck))
			deck.setMostRanking("PlushStraight");
		// TODO 2. isFourcard? Good
		else if(deckService.isFourCard(deck))
			deck.setMostRanking("Fourcard");
		// TODO 3. isPullHouse? Good
		else if(deckService.isPullHouse(deck))
			deck.setMostRanking("PullHouse");
		// TODO 4. isPlush? Good
		else if(deckService.isPlush(deck))
			deck.setMostRanking("Plush");
		// TODO 5. isStraight? Good
		else if(deckService.isStraight(cardNumList))
			deck.setMostRanking("Straight");
		// TODO 6. isTriple?
		else if(deckService.isTriple(deck))
			deck.setMostRanking("Triple");
		// TODO 7. isTwopair?
		else if(deckService.isTwopair(deck))
			deck.setMostRanking("Twopair");
		// TODO 8. isOnepair?
		else if(deckService.isOnepair(deck))
			deck.setMostRanking("Onepair");
		// TODO 9. isTop?
		else
			deck.setMostRanking("Top");
		
		System.out.println(deck.getMostRanking().toString());
		return null;
	}
	
	@Test
	void test()
	{	
		pokerService.setStartCardList();
		DeckVo deck = new DeckVo();
//		List<CardVo> list = new ArrayList<>();
//		CardVo card_1 = new CardVo(10,4);
//		CardVo card_2 = new CardVo(9,4);
//		CardVo card_3 = new CardVo(10,3);
//		CardVo card_4 = new CardVo(1,4);
//		CardVo card_5 = new CardVo(1,3);
//		CardVo card_6 = new CardVo(2,4);
//		CardVo card_7 = new CardVo(4,4);
//		
//		list.add(card_1);
//		list.add(card_2);
//		list.add(card_3);
//		list.add(card_4);
//		list.add(card_5);
//		list.add(card_6);
//		list.add(card_7);
//		
		deck.setCardList(pokerService.makeTestDeck());
//		deck.setCardList(list);

		System.out.println(deck.getCardList().toString());
		calculateDeck(deck);
	}
}
