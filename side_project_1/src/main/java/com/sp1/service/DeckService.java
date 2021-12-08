package com.sp1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.sp1.vo.CardVo;
import com.sp1.vo.DeckVo;

public class DeckService
{

	// 카드 숫자, 패턴 중복개수 확인
	public TreeMap<Integer, Integer> countOverlapCard(List<Integer> list) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < list.size(); i++)
		{
			int count = 1;
			for (int j = i + 1; j < list.size(); j++)
			{
				if (list.get(i) == list.get(j))
				{
					list.remove(j);
					count++;
					j--;
				}
			}
			map.put(count,list.get(i)); // cardNum or cardPattern , 개수  
		}
		
		return map;
	}
	
	// isOnepair
	public boolean isOnepair(DeckVo deck)
	{
		List<Integer> cardNumList = deck.getCardList().stream().map(card -> card.getNum()).collect(Collectors.toList());// 숫자
		// 숫자 중복 제거
		List<Integer> overlapRemove_cardNumList =  cardNumList.stream().distinct().collect(Collectors.toList());
		TreeMap<Integer, Integer> countNum = countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey();
		
		return (countOverlap == 2 && overlapRemove_cardNumList.size() == 6) ? true : false;
	}
	
	// isTwopair
	public boolean isTwopair(DeckVo deck)
	{
		List<Integer> cardNumList = deck.getCardList().stream().map(card -> card.getNum()).collect(Collectors.toList());// 숫자
		// 숫자 중복 제거
		List<Integer> overlapRemove_cardNumList =  cardNumList.stream().distinct().collect(Collectors.toList());
		TreeMap<Integer, Integer> countNum = countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey();
		
		return (countOverlap == 2 && (overlapRemove_cardNumList.size() == 4 || overlapRemove_cardNumList.size() == 5)) ? true : false;
	}
	
	// isTriple
	public boolean isTriple(DeckVo deck)
	{
		List<Integer> cardNumList = deck.getCardList().stream().map(card -> card.getNum()).collect(Collectors.toList());// 숫자
		// 숫자 중복 제거
		List<Integer> overlapRemove_cardNumList =  cardNumList.stream().distinct().collect(Collectors.toList());
		TreeMap<Integer, Integer> countNum = countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey();
		
		return (countOverlap == 3 && overlapRemove_cardNumList.size() == 5) ? true : false;
	}
	
	// isStraight
	public boolean isStraight(List<Integer> cardNumList)
	{
		System.out.println("Straight cardNumList ::" +cardNumList.toString());
		List<Integer> sortList = cardNumList.stream().sorted().collect(Collectors.toList()); // 정렬
		int count = 0;
		for (int i = 0; i < sortList.size() - 1; i++)
			if (sortList.get(i) + 1 == sortList.get(i + 1)) count++;
			else if(sortList.get(i) + 1 != sortList.get(i + 1) && count != 4) count = 0;
			else continue;
		
		return (count >= 4)? true : false;
	}
	
	// isPlush
	public boolean isPlush(DeckVo deck)
	{
		List<Integer> cardPatternList = deck.getCardList().stream().map(card -> card.getPattern()).collect(Collectors.toList());// 패턴
		TreeMap<Integer, Integer> countPattern = countOverlapCard(cardPatternList);
		int countOverlap = countPattern.lastEntry().getKey();

		return (countOverlap >= 5)? true : false;
	}
	
	// isPullHouse
	public boolean isPullHouse(DeckVo deck)
	{
		List<Integer> cardNumList = deck.getCardList().stream().map(card -> card.getNum()).collect(Collectors.toList());// 숫자
		// 숫자 중복 제거
		TreeMap<Integer, Integer> countNum = countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey();
		
		List<Integer> overlapRemove_cardNumList =  cardNumList.stream().distinct().collect(Collectors.toList());
		System.out.println(countNum.toString());
		if(countOverlap == 3)
		{
			if(overlapRemove_cardNumList.size() == 4 || overlapRemove_cardNumList.size() == 3)
				return true;
			else
				return false; // 트리플
		}
		
		return false;
	}
	
	// isFourCard
	public boolean isFourCard(DeckVo deck)
	{
		List<Integer> cardNumList = deck.getCardList().stream().map(card -> card.getNum()).collect(Collectors.toList());// 숫자
		TreeMap<Integer, Integer> countNum = countOverlapCard(cardNumList);
		int countOverlap = countNum.lastEntry().getKey(); // 가장 많이 중복된 횟수
		
		return (countOverlap == 4) ? true : false;
	}
	
	// isPlushStraight
	public boolean isPlushStraight(DeckVo deck)
	{
		List<Integer> cardPatternList = deck.getCardList().stream().map(card -> card.getPattern()).collect(Collectors.toList());// 패턴
		TreeMap<Integer, Integer> countPattern = countOverlapCard(cardPatternList);
		int countOverlap = countPattern.lastEntry().getKey();
		int pattern = countPattern.lastEntry().getValue();
		
		List<Integer> cardNumlist = new ArrayList<>();
		// isPlush?
		if (countOverlap >= 5)
		{
			for (CardVo card : deck.getCardList())
				if (card.getPattern() == pattern) 
					cardNumlist.add(card.getNum());
			
			// isStraight?
			return (isStraight(cardNumlist))? true : false;
		}
		
		return false;
	}
}
