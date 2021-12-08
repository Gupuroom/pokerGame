package com.sp1.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultVo
{
	private String result; //최종 결과
	private int resultCode; //최종 결과 코드
	
	private CardVo mostCard; // keyCard
}
