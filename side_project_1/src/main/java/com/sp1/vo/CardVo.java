package com.sp1.vo;

import java.util.regex.Pattern;

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
}
