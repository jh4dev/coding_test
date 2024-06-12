package practice.lvl2;

import java.util.Arrays;

/**
 * 땅따먹기 게임을 하려고 합니다. 
 * 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 
 * 모든 칸에는 점수가 쓰여 있습니다. 1행부터 땅을 밟으며 한 행씩 내려올 때, 
 * 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 단, 땅따먹기 게임에는 한 행씩 내려올 때, 
 * 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.

예를 들면,

| 1 | 2 | 3 | 5 |

| 5 | 6 | 7 | 8 |

| 4 | 3 | 2 | 1 |

로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.

마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요. 
위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 
3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.
 * */
public class TakingLand {

	public static void main(String[] args) {
		int[][] land = {
				{1,2,3,5},	
				{5,6,7,8},	
				{4,3,2,1}	
		};
		System.out.println(solution(land));
	}
	
	/*
	 * 완전탐색 : 시간복잡도 노답
	 * DP 접근
	 * */
	static int solution(int[][] land) {
        
        int[] prevRow = Arrays.copyOf(land[0], 4);
        //본인 열을 제외한 값들과의 합 중 MAX값 선택
        
        int row0, row1, row2, row3 = 0;
        for(int i = 1; i < land.length; i++) {
        	
        	row0 = getMaxValue(prevRow, land[i][0], 0);
        	row1 = getMaxValue(prevRow, land[i][1], 1);
        	row2 = getMaxValue(prevRow, land[i][2], 2);
        	row3 = getMaxValue(prevRow, land[i][3], 3);
        	
        	prevRow[0] = row0;
        	prevRow[1] = row1;
        	prevRow[2] = row2;
        	prevRow[3] = row3;
        	
        }
        
        Arrays.sort(prevRow);

        return prevRow[3];
    }
	
	public static int getMaxValue(int[] prevRow, int nowVal, int rowNum) {
		
		int maxValue = 0;
		for(int i = 0; i < prevRow.length; i++) {
			if(i == rowNum) continue;
			
			if(maxValue < nowVal + prevRow[i]) {
				maxValue = nowVal + prevRow[i];
			}
		}
		
		return maxValue;
	}
}
