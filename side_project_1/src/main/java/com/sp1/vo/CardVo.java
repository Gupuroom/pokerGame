package com.sp1.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardVo
{
	private int num;
	private CardPattern pattern;
	
	public CardVo(CardPattern pattern, int num)
	{
		this.pattern = pattern;
		this.num = num;
	}
	
	public CardVo(int pattern, int num) // 시작카드 세팅
	{
		switch(pattern)
		{
			case 0: this.pattern = CardPattern.HEART; break;
			case 1: this.pattern = CardPattern.CLOVER; break;
			case 2: this.pattern = CardPattern.DIAMOND; break;
			case 3: this.pattern = CardPattern.SPADE; break;
			default:
				break;
		}
		this.num = num;
	}
}
