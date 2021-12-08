package com.sp1.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeckVo
{
	private List<CardVo> cardList;
	
	private int mostOverlapCardNum; // 가장 많이 중복된 카드 숫자.
	private int mostOverlapCardNumCount; // 중복된 숫자 개수.
	
	private int mostOverlapCardPattern; // 가장 많이 중복된 카드 패턴.
	private int mostOverlapCardPatternCount; // 중복된 패턴 개수
	
	private int nextOverlapCardNum; // mostOverlapCardCount = 3 or 2 ( 트리플이거나 페어여서 뒷값을 확인해야 할 때 사용 ) 두 번째로 많이 중복된 카드
	private int nextOverlapCardCount; // 중복된 숫자 개수
	
	private List<CardVo> meaningCardList; // 의미 있는 카드 List
	
	private String mostRanking; // 가장 높은 랭킹의 패
	
}
