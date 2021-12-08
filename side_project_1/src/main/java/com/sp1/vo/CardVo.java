package com.sp1.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardVo
{
	private int pattern;
	private int num;
	
	public CardVo(int pattern, int num)
	{
		this.pattern = pattern;
		this.num = num;
	}
}
