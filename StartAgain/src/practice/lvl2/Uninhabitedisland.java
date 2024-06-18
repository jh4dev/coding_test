package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 무인도
 * 
 * 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다. 
 * 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다. 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며,
 * 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다. 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 
 * 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다. 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 
 * 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다. 
 * 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.

	지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요. 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
	
	제한사항
		3 ≤ maps의 길이 ≤ 100
		3 ≤ maps[i]의 길이 ≤ 100
		maps[i]는 'X' 또는 1 과 9 사이의 자연수로 이루어진 문자열입니다.
		지도는 직사각형 형태입니다.
	입출력 예
		maps								result
		["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
		["XXX","XXX","XXX"]					[-1]
 * */
public class Uninhabitedisland {

	public static void main(String[] args) {
		
		String[] maps = {
			"11111XXXXX",
			"1X1X1XXX11", 
			"X1X1X1X1X1"
		};
		
		System.out.println(Arrays.toString(solution(maps)));
	}
	
	static String[][] 		mapArr;
	static List<Integer> 	answerList;
	
	public static int[] solution(String[] maps) {
        
        answerList = new ArrayList<>();
		mapArr = new String[maps.length][maps[0].length()];
        
		for(int i = 0; i < maps.length; i++) {
			//String Array to int Array
			mapArr[i] = maps[i].split("");
		}
        
        /*
         * DP
         * 
         * 1. 0,0 부터 X가 아닌 수가 나오는 경우, 해당 위치를 기준으로 상/하/좌/우 로 더해가며 진행(DFS), 확인한 칸은 0으로 치환
         * 		> 0,0 에다가 더해감
         * 2. 상/하/좌/우 모두 0 또는 X 인 경우 answerList에 추가
         * */
		int seaCnt = 0;
		
		for(int i = 0; i < mapArr.length; i++) {
			for(int j = 0; j < mapArr[i].length; j++) {
				if(mapArr[i][j].equals("X")) {
					seaCnt++;
					continue;
				} else if(mapArr[i][j].equals("0")) {
					continue;
				} else {
					dfs(i, j, i, j);
				}
			}
		}
		
		print();
		for(int i = 0; i < mapArr.length; i++) {
			for(int j = 0; j < mapArr[i].length; j++) {
				if(!(mapArr[i][j].equals("X") || mapArr[i][j].equals("0"))) {
					answerList.add(Integer.parseInt(mapArr[i][j]));
				}
			}
		}
		
		//전부 X 인 경우 섬 없음 -> -1 리턴
		if(seaCnt == mapArr.length * mapArr[0].length) return new int[] {-1};
        
		//오름차순 정렬
		Collections.sort(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static void dfs(int baseRow, int baseCol, int row, int col) {
		
		if(!(baseRow == row && baseCol == col)) {
			mapArr[baseRow][baseCol] = sumValues(mapArr[baseRow][baseCol], mapArr[row][col]);
			mapArr[row][col] = "0";
		}
		//동
		if(col+1 < mapArr[0].length && !(mapArr[row][col+1].equals("X") || mapArr[row][col+1].equals("0"))) {
			dfs(baseRow, baseCol, row, col+1);
		}
		//서
		if(col-1 >= 0 && !(mapArr[row][col-1].equals("X") || mapArr[row][col-1].equals("0"))) {
			dfs(baseRow, baseCol, row, col-1);
		}
		//남
		if(row+1 < mapArr.length && !(mapArr[row+1][col].equals("X") || mapArr[row+1][col].equals("0"))) {
			dfs(baseRow, baseCol, row+1, col);
		}
		//북
		if(row-1 >= 0 && !(mapArr[row-1][col].equals("X") || mapArr[row-1][col].equals("0"))) {
			dfs(baseRow, baseCol, row-1, col);
		}
	}
	
	public static String sumValues(String s1, String s2) {
		return String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2));
	}
	
	public static void print() {
		
		for(String[] arr : mapArr) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("----------------");
	}
}
