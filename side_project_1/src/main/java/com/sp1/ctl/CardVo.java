package com.sp1.ctl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardVo
{
	private int num;
	private int pattern;
	
	public CardVo(int num ,int pattern){
		this.num = num;
		this.pattern = pattern;
	}
}
