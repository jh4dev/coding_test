package practice.lvl1;

import java.util.Arrays;
import java.util.Collections;

public class ReverseOrderNum {

	public static void main(String[] args) {
		
		System.out.println(solution(2424333));
	}
	
	public static long solution(long n) {
		
		String[] nstrArr = String.valueOf(n).split("");
		Arrays.sort(nstrArr, Collections.reverseOrder());
		return Long.parseLong(String.join("", nstrArr));
	}
	
	public static long solution_bak(long n) {
		
		String[] nStrArr = String.valueOf(n).split("");

		//1. String Array to int Array
		//2. 역순 정렬을 위한 int Array to Integer Array;
		Integer[] arr = Arrays.stream(
					Arrays.stream(nStrArr).mapToInt(Integer::parseInt).toArray()
				).boxed().toArray(Integer[]::new);
		
		//역순 정렬
		Arrays.sort(arr, Collections.reverseOrder());
		
		String str = "";
		for(Integer i : arr) {
			str+= String.valueOf(i);
		}
		
		return Long.parseLong(str);
	}
}
