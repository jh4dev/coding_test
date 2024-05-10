package practice.lvl0;

import java.util.Arrays;

//옹알이(1)
public class Babbling {

	public static void main(String[] args) {
		
		String[] csArr = {"aya", "ye", "woo", "ma"};
		
		String[] babArr = {"aya", "yee", "u", "maa", "wyeoo"};
		int answer = 0;
		
		//치환 사용
		for(String bs : babArr) {
			for(String cs : csArr) {
				if(bs.indexOf(cs) > -1) {
					bs = bs.replaceAll(cs, "x");
				}
			}
			if(bs.replaceAll("x", "").length() == 0) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
