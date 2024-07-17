package practice.lvl3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectIsland {

	public static void main(String[] args) {
		
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(n, costs));
	}
	
	public static class Point implements Comparable<Point>{
        int node, cost;
        
        public Point (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo (Point o) {
            return this.cost - o.cost;
        }
    }
    
    public static List<List<Point>> map = new ArrayList<>();
    
    public static int solution(int n, int[][] costs) {
        //초기화 
        for (int i = 0; i < n; i++)
            map.add(new ArrayList<>());
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int val = costs[i][2];
            map.get(from).add(new Point(to, val));
            map.get(to).add(new Point(from, val));
        }
        
        //프림 알고리즘 
        boolean[] visit = new boolean[n];
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0));
        
        int result = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            if (visit[cur.node]) continue;
            visit[cur.node] = true;
            result += cur.cost;
            
            for (int i = 0; i < map.get(cur.node).size(); i++) {
                int next = map.get(cur.node).get(i).node;
                int cost = map.get(cur.node).get(i).cost;
                if (visit[next]) continue;
                q.add(new Point(next, cost));
            }
        }
        
        return result;
    }
}
