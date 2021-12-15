package com.sp1.service;

import java.util.ArrayList;
import java.util.List;

import com.sp1.vo.CardPattern;
import com.sp1.vo.CardVo;
import com.sp1.vo.DeckVo;

public class TestService
{
	public DeckVo makeFourCardTestDeck()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> cardList = new ArrayList<CardVo>();
		cardList.add(new CardVo(CardPattern.CLOVER,1));
		cardList.add(new CardVo(CardPattern.CLOVER,2));
		cardList.add(new CardVo(CardPattern.CLOVER,3));
		cardList.add(new CardVo(CardPattern.CLOVER,4));
		cardList.add(new CardVo(CardPattern.HEART,4));
		cardList.add(new CardVo(CardPattern.DIAMOND,4));
		cardList.add(new CardVo(CardPattern.SPADE,4));
		
		deck.setCardList(cardList);
		
		return deck;
	}
	
	public DeckVo makeFullHouseTestDeck()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> cardList = new ArrayList<CardVo>();
		cardList.add(new CardVo(CardPattern.SPADE,10));
		cardList.add(new CardVo(CardPattern.DIAMOND,10));
		cardList.add(new CardVo(CardPattern.SPADE,2));
		cardList.add(new CardVo(CardPattern.HEART,10));
		cardList.add(new CardVo(CardPattern.DIAMOND,2));
		cardList.add(new CardVo(CardPattern.SPADE,4));
		cardList.add(new CardVo(CardPattern.SPADE,1));
		
		deck.setCardList(cardList);
		
		return deck;
	}
	
	public DeckVo makePlushTestDeck()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> cardList = new ArrayList<CardVo>();
		cardList.add(new CardVo(CardPattern.SPADE,10));
		cardList.add(new CardVo(CardPattern.DIAMOND,5));
		cardList.add(new CardVo(CardPattern.SPADE,2));
		cardList.add(new CardVo(CardPattern.HEART,6));
		cardList.add(new CardVo(CardPattern.SPADE,3));
		cardList.add(new CardVo(CardPattern.SPADE,4));
		cardList.add(new CardVo(CardPattern.SPADE,1));
		
		deck.setCardList(cardList);
		
		return deck;
	}
	
	public DeckVo makeStraightTestDeck()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> cardList = new ArrayList<CardVo>();
		cardList.add(new CardVo(CardPattern.SPADE,13));
		cardList.add(new CardVo(CardPattern.DIAMOND,12));
		cardList.add(new CardVo(CardPattern.SPADE,11));
		cardList.add(new CardVo(CardPattern.HEART,10));
		cardList.add(new CardVo(CardPattern.DIAMOND,7));
		cardList.add(new CardVo(CardPattern.SPADE,2));
		cardList.add(new CardVo(CardPattern.SPADE,1));
		
		deck.setCardList(cardList);
		
		return deck;
	}
	
	public DeckVo makeTripleTestDeck()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> cardList = new ArrayList<CardVo>();
		cardList.add(new CardVo(CardPattern.SPADE,10));
		cardList.add(new CardVo(CardPattern.DIAMOND,10));
		cardList.add(new CardVo(CardPattern.SPADE,2));
		cardList.add(new CardVo(CardPattern.HEART,10));
		cardList.add(new CardVo(CardPattern.SPADE,3));
		cardList.add(new CardVo(CardPattern.HEART,4));
		cardList.add(new CardVo(CardPattern.SPADE,1));
		
		deck.setCardList(cardList);
		
		return deck;
	}
	
	public DeckVo makeTwopairTestDeck()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> cardList = new ArrayList<CardVo>();
		cardList.add(new CardVo(CardPattern.SPADE,10));
		cardList.add(new CardVo(CardPattern.DIAMOND,10));
		cardList.add(new CardVo(CardPattern.SPADE,2));
		cardList.add(new CardVo(CardPattern.HEART,2));
		cardList.add(new CardVo(CardPattern.SPADE,3));
		cardList.add(new CardVo(CardPattern.HEART,4));
		cardList.add(new CardVo(CardPattern.SPADE,1));
		
		deck.setCardList(cardList);
		
		return deck;
	}
	
	public DeckVo makeOnepairTestDeck()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> cardList = new ArrayList<CardVo>();
		cardList.add(new CardVo(CardPattern.SPADE,10));
		cardList.add(new CardVo(CardPattern.DIAMOND,10));
		cardList.add(new CardVo(CardPattern.SPADE,8));
		cardList.add(new CardVo(CardPattern.HEART,6));
		cardList.add(new CardVo(CardPattern.SPADE,3));
		cardList.add(new CardVo(CardPattern.HEART,4));
		cardList.add(new CardVo(CardPattern.CLOVER,1));
		
		deck.setCardList(cardList);
		
		return deck;
	}
	
	public DeckVo makeTopTestDeck()
	{
		DeckVo deck = new DeckVo();
		List<CardVo> cardList = new ArrayList<CardVo>();
		cardList.add(new CardVo(CardPattern.HEART,12));
		cardList.add(new CardVo(CardPattern.DIAMOND,10));
		cardList.add(new CardVo(CardPattern.SPADE,8));
		cardList.add(new CardVo(CardPattern.HEART,6));
		cardList.add(new CardVo(CardPattern.SPADE,3));
		cardList.add(new CardVo(CardPattern.HEART,4));
		cardList.add(new CardVo(CardPattern.CLOVER,1));
		
		deck.setCardList(cardList);
		
		return deck;
	}
}
