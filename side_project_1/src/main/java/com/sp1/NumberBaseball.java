package com.sp1;

public class NumberBaseball
{
	public static void main(String[] args)
	{
		String num = "123"; // 초기 숫자
		String inputNum = "789"; //입력 숫자
		
		String result = checkNum(num,inputNum);
		System.out.println(result);
	}
	
	public static String checkNum(String num, String inputNum)
	{
		int S = 0; // 스트라이크
		int B = 0; // 볼
		for (int location = 0; location < 3; location++)
		{
			if (num.substring(location, location + 1).equals(inputNum.substring(location, location + 1)))
				S++;
			else if (num.contains(inputNum.substring(location, location + 1)))
				B++;
			else
				continue;
		}
		String result = S+"S "+B+"B";
		
		// 3S
		if(S == 3)
			result = "승리하셨습니다.";
		
		// 0S 0B
		if(S == 0 && B == 0)
			result = "Out";
		
		return result;
	}
}
