package lvl2;

import java.util.Arrays;

public class QuadTree {

	public static void main(String[] args) {

		int[][] arr = {	
				{1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1},
				{0,0,0,0,1,1,1,1},
				{0,1,0,0,1,1,1,1},
				{0,0,0,0,0,0,1,1},
				{0,0,0,0,0,0,0,1},
				{0,0,0,0,1,0,0,1},
				{0,0,0,0,1,1,1,1},
			
		};
//		System.out.println();
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	
	public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        System.out.println(Arrays.toString(answer));

//        recursive(arr, new int[] {0,0}, new int[] {arr.length-1, arr[0].length-1}, new int[]{(arr.length-1)/2, (arr[0].length-1)/2}, answer);
        
        recursive(arr, new int [] {0, 0}, arr.length, answer);
        
        return answer;
    }
	
	private static void recursive(int[][] arr, int start[], int len, int[] answer) {
		
		//1. 모든 원소 같은 값인지 체크
		boolean isAllSame = true;
		Loop1:
		for(int i = start[0]; i < start[0] + len; i++) {
			for(int j = start[1]; j < start[1] + len; j++) {
				if(arr[start[0]][start[1]] != arr[i][j]) {
					isAllSame = false;
					break Loop1;
				}
			}
		}
		
		if(isAllSame) {
			//2. 같으면 answer 
			answer[arr[start[0]][start[1]]] ++;
		} else {
			//3. 다르면 4등분
			//좌상 
			recursive(arr, start, len / 2, answer);
			//우상  
			recursive(arr, new int[] {start[0], start[1] + len / 2}, len / 2, answer);
			//좌하 
			recursive(arr, new int[] {start[0] + len / 2, start[1]}, len / 2, answer);
			//우하
			recursive(arr, new int[] {start[0] + len / 2, start[1] + len / 2}, len / 2, answer);
		}

	}
	
	//실패패패
//	private static void recursivefail(int[][] arr, int[] lt, int[] rb, int[] md, int[] answer) {
//
//		/*
//		 * lt -> left top
//		 * md -> middle
//		 * rb -> right bot
//		 * */ 
//		
//		//더이상 쪼개면 안
//		if(md[0] - lt[0] == 0) {
//			  for(int i = lt[0]; i <= rb[0]; i++) {
//				  for(int j = lt[1]; j <= rb[1]; j++) {
//					  if(arr[i][j] == 0) {
//						  answer[0]++;
//					  } else if(arr[i][j] == 1){
//						  answer[1]++;
//					  }
//					  arr[i][j] = -1;
//				  }
//			  }
//		} else {
//			int[] sumVal = new int[4];
//			int[] rpVal = new int[4];
//			rpVal[0] = arr[lt[0]][lt[1]];
//			rpVal[1] = arr[md[0]+1][lt[0]];
//			rpVal[2] = arr[lt[0]][md[1]+1];
//			rpVal[3] = arr[md[0]+1][md[1]+1];
//			
//			for(int i = lt[0]; i <= rb[0]; i++) {
//				
//				for(int j = lt[1]; j <= rb[1]; j++) {
//					
//					int val = arr[i][j];
//					
//					if(val != -1) {
//						//좌상 {lt[0], lt[1]} ~ {md[0], md[1]}
//						if(i <= md[0] && j <= md[1]) {
//							if(val != rpVal[0]) {
//								sumVal[0] = -1;
//								recursive(arr, lt, md, new int[]{md[0]/2, md[1]/2}, answer);
//							} else {
//								sumVal[0] += val;
//							}
//						}
//						//좌하 {md[0]+1, lt[1]} ~ {rb[0], md[1]}
//						else if(i> md[0] && j <= md[1]) {
//							if(val != rpVal[1]) {
//								sumVal[1] = -1;
//								recursive(arr, new int[] {md[0]+1, lt[1]}, new int[] {rb[0], md[1]}, new int[] {(md[0]+1+rb[0])/2, (lt[0]+md[1])/2}, answer);
//							} else {
//								sumVal[1] += val;
//							}
//						}
//						//우상 {lt[0], md[1]+1} ~ {md[0], rb[1]}
//						else if(i <= md[0] && j > md[1] ) {
//							if(val != rpVal[2]) {
//								sumVal[2] = -1;
//								recursive(arr, new int[] {lt[0], md[1]+1}, new int[] {md[0], rb[1]}, new int[] {(lt[0]+md[0])/2, (md[1]+1+rb[1])/2}, answer);
//							} else {
//								sumVal[2] += val;
//							}
//						}
//						//우하 {md[0]+1, md[1]+1} ~ {rb[0], rb[1]}
//						else if(i > md[0] && j > md[1]) {
//							if(val != rpVal[3]) {
//								sumVal[3] = -1;
//								recursive(arr, new int[] {md[0]+1, md[1]+1}, new int[] {rb[0], rb[1]}, new int[] {(md[0]+1+rb[0])/2, (md[1]+1+rb[1])/2}, answer);
//							} else {
//								sumVal[3] += val;
//							}
//						}	
//					}
//						
//				}
//			}
//			
//			for(int i = 0; i < 4; i++) {
//				if(rpVal[i] != -1) {
//					if(sumVal[i] == rpVal[i] * Math.pow((rb[1] + 1)/2, 2)) {
//						answer[rpVal[i]] += 1;
//					}
//				}
//				
//			}
//		}
//
//		
//	}
}
