package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * 테이블 해시 함수
 * 
 * 완호가 관리하는 어떤 데이터베이스의 한 테이블은 모두 정수 타입인 컬럼들로 이루어져 있습니다. 
 * 테이블은 2차원 행렬로 표현할 수 있으며 열은 컬럼을 나타내고, 행은 튜플을 나타냅니다.
	첫 번째 컬럼은 기본키로서 모든 튜플에 대해 그 값이 중복되지 않도록 보장됩니다. 
	완호는 이 테이블에 대한 해시 함수를 다음과 같이 정의하였습니다.
	
	해시 함수는 col, row_begin, row_end을 입력으로 받습니다.
	테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되, 
	만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
	정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
	row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
	테이블의 데이터 data와 해시 함수에 대한 입력 col, row_begin, row_end이 주어졌을 때 
	테이블의 해시 값을 return 하도록 solution 함수를 완성해주세요.
	
	제한 사항
		1 ≤ data의 길이 ≤ 2,500
		1 ≤ data의 원소의 길이 ≤ 500
		1 ≤ data[i][j] ≤ 1,000,000
		data[i][j]는 i + 1 번째 튜플의 j + 1 번째 컬럼의 값을 의미합니다.
		1 ≤ col ≤ data의 원소의 길이
		1 ≤ row_begin ≤ row_end ≤ data의 길이
 * */
public class TableHashFunction {

	public static void main(String[] args) {
	
		int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
		int col = 2;
		int row_begin = 2;
		int row_end = 3;
		
		System.out.println(solution(data, col, row_begin, row_end));
	}
	
	public static int solution(int[][] data, int col, int row_begin, int row_end) {
        List<int[]> tupleList = new ArrayList<>();
        
        //int array to Integer List
        for(int[] d : data) {
//        	tupleList.add(Arrays.stream(d).boxed().collect(Collectors.toList()));
        	tupleList.add(d);
        }
        
        /*
         * 1. 테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되, 
				만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
         * */
        tupleList.sort((o1, o2) -> {
        	int compare = o1[col-1] - o2[col-1];
        	if(compare == 0) {
        		return o2[0] - o1[0];
        	}
        	return compare;
        });
        
        /*
         * 2. 정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
			row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
         * */
        int[] tuple = null;
        int result = -1;
        for(int i = row_begin; i <= row_end; i++) {
        	tuple = tupleList.get(i-1);
        	int modSum = 0;
        	for(int j = 0; j < tuple.length; j++) {
        		modSum += (tuple[j] % i);
        	}
        	
        	if(result == -1) {
        		result = modSum;
        	} else {
        		result ^= modSum;
        	}
        }
        
        return result;
    }

	
}
