package sample;

import java.util.HashSet;

public class NQueenRetry {

	public static void main(String[] args) {

		int n = 4;
		
		System.out.println(new Solution().solution(n));
	}
	
	static class Solution {
		
		int answer;
		int[] chess;
		public int solution(int n) {
			answer = 0;
			chess = new int[n];
			
			backtracking(new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), 0, n);
			
			return answer;
		}
		
		public void backtracking(HashSet<Integer> colSet, HashSet<Integer> leftSet, HashSet<Integer> rightSet, int row, int n) {
			
			if(row == n) {
				answer++;
				return;
			} else {
				for(int i = 0; i < n; i++) {
					
					if(!colSet.contains(i) && !leftSet.contains(row - i) && !rightSet.contains(row + i)) {
						colSet.add(i);
						leftSet.add(row-i);
						rightSet.add(row+i);
						backtracking(colSet, leftSet, rightSet, row + 1, n);
						colSet.remove(i);
						leftSet.remove(row - i);
						rightSet.remove(row + i);
					}
				}
			}
		}
	}
}
