package last.dance.bf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ElectTower {

	public static void main(String[] args) {
		
		int n = 7;
		int[][] wired = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
		
		System.out.println(new Solution().solution(n, wired));
	}
	
	static class Solution{
		
		Map<Integer, Set<Integer>> tree = new HashMap<>();

		public int solution(int n, int[][] wires) {
			int answer = Integer.MAX_VALUE;
			//전력망을 트리형태로 구성 (순회 없음)
			Set<Integer> tempSet;
			for(int i = 0; i < wires.length; i++) {
				//0에서 1로 가는 선
				tempSet = tree.getOrDefault(wires[i][0], new HashSet<Integer>());
				tempSet.add(wires[i][1]);
				tree.put(wires[i][0], tempSet);
				
				//1에서 0으로 가는 선
				tempSet = tree.getOrDefault(wires[i][1], new HashSet<Integer>());
				tempSet.add(wires[i][0]);
				tree.put(wires[i][1], tempSet);
			}
			
			System.out.println(tree);
			
			Set<Integer> s1, s2;
			int count;
			//tree 에서 wires를 하나씩 제거하며 확인
			for(int i = 0; i < wires.length; i++) {
				
				//0 -> 1 제거
				s1 = tree.get(wires[i][0]);
				s1.remove(wires[i][1]);
				tree.put(wires[i][0], s1);
				
				//1 -> 0 제거
				s2 = tree.get(wires[i][1]);
				s2.remove(wires[i][0]);
				tree.put(wires[i][1], s2);
				
				//계산
				count = getCountTowers(new boolean[n+1], 1);
				answer = Math.min(answer, Math.abs((n - count) - count));
				
				//0 -> 1 추가
				s1.add(wires[i][1]);
				tree.put(wires[i][0], s1);
				
				//1 -> 0 추가
				s2.add(wires[i][0]);
				tree.put(wires[i][1], s2);
			}
			
			System.out.println();
			
			return answer;
		}
		
		
		public int getCountTowers(boolean[] visited, int root) {
			int cnt = 1;
			visited[root] = true;
			List<Integer> childList = new ArrayList<>(tree.get(root));
			for(int i = 0; i < childList.size(); i++) {
				if(!visited[childList.get(i)]) {
					cnt += getCountTowers(visited, childList.get(i));
				}
			}
			return cnt;
		}
	}
}
