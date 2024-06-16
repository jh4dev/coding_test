package practice.lvl2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * 
 * N개의 마을로 이루어진 나라가 있습니다. 이 나라의 각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여되어 있습니다. 각 마을은 양방향으로 통행할 수 있는 도로로 연결되어 있는데, 서로 다른 마을 간에 이동할 때는 이 도로를 지나야 합니다. 도로를 지날 때 걸리는 시간은 도로별로 다릅니다. 현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 합니다. 각 마을로부터 음식 주문을 받으려고 하는데, N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다. 다음은 N = 5, K = 3인 경우의 예시입니다.

	위 그림에서 1번 마을에 있는 음식점은 [1, 2, 4, 5] 번 마을까지는 3 이하의 시간에 배달할 수 있습니다.
	 그러나 3번 마을까지는 3시간 이내로 배달할 수 있는 경로가 없으므로 3번 마을에서는 주문을 받지 않습니다. 
	 따라서 1번 마을에 있는 음식점이 배달 주문을 받을 수 있는 마을은 4개가 됩니다.
	마을의 개수 N, 각 마을을 연결하는 도로의 정보 road, 음식 배달이 가능한 시간 K가 매개변수로 주어질 때, 
	음식 주문을 받을 수 있는 마을의 개수를 return 하도록 solution 함수를 완성해주세요.
	
	제한사항
		마을의 개수 N은 1 이상 50 이하의 자연수입니다.
		road의 길이(도로 정보의 개수)는 1 이상 2,000 이하입니다.
		road의 각 원소는 마을을 연결하고 있는 각 도로의 정보를 나타냅니다.
		road는 길이가 3인 배열이며, 순서대로 (a, b, c)를 나타냅니다.
		a, b(1 ≤ a, b ≤ N, a != b)는 도로가 연결하는 두 마을의 번호이며, c(1 ≤ c ≤ 10,000, c는 자연수)는 도로를 지나는데 걸리는 시간입니다.
		두 마을 a, b를 연결하는 도로는 여러 개가 있을 수 있습니다.
		한 도로의 정보가 여러 번 중복해서 주어지지 않습니다.
		K는 음식 배달이 가능한 시간을 나타내며, 1 이상 500,000 이하입니다.
		임의의 두 마을간에 항상 이동 가능한 경로가 존재합니다.
		1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수를 return 하면 됩니다.

 * */
public class FindRoads {

	public static void main(String[] args) {
		
		int N = 6;
		int K = 4;
		int[][] road = {{1, 2, 4}, {1, 3, 1}, {3, 4, 1}, {4, 2, 1}, {2, 5, 1}};
		
		System.out.println(solution(N, road, K)); 
	}
	
	public static int solution(int N, int[][] road, int K) {
		
		if(N == 1) return 1;
		// N 이 필요한 이유가 뭐지...
        Map<Integer, List<Road>> roadMap = new HashMap<>();
        List<Road> rList = null;
        
        for(int[] r : road) {
        	
        	rList = roadMap.getOrDefault(r[0], new ArrayList<>());
        	rList.add(new Road(r[0], r[1], r[2]));
        	roadMap.put(r[0], rList);
        	
        	rList = roadMap.getOrDefault(r[1], new ArrayList<>());
        	rList.add(new Road(r[1], r[0], r[2]));
        	roadMap.put(r[1], rList);
        }
        
        for(Entry<Integer, List<Road>> entry : roadMap.entrySet()) {
        	
        	entry.getValue().sort((o1, o2) -> {
        		int endCompare = o1.end - o2.end;
    			if(endCompare == 0) {
    				return o1.cost - o2.cost;
    			} else return endCompare;
        	});
        }
       
        //bfs
        int nowPoint = 1;
        
        Queue<Village> queue = new LinkedList<>();
        queue.add(new Village(nowPoint, 0, roadMap.get(nowPoint)));
        
        Map<Integer, Integer> answerMap = new HashMap<Integer, Integer>(); 
        
        PriorityQueue<Road> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(roads -> roads.cost));
        Set<Integer> visited = new HashSet<>();

        for (int r : roadMap.keySet()) {
        	answerMap.put(r, Integer.MAX_VALUE);
        }
        
        answerMap.put(1, 0);
        priorityQueue.add(new Road(1, 1, 0));

        while (!priorityQueue.isEmpty()) {
            Road current = priorityQueue.poll();
            int currentNode = current.end;

            if (!visited.add(currentNode)) {
                continue;
            }

            for (Road neighbor : roadMap.getOrDefault(currentNode, Collections.emptyList())) {
                if (visited.contains(neighbor.end)) {
                    continue;
                }

                int newDist = answerMap.get(currentNode) + neighbor.cost;
                if (newDist < answerMap.get(neighbor.end)) {
                	answerMap.put(neighbor.end, newDist);
                    priorityQueue.add(new Road(neighbor.start, neighbor.end, newDist));
                }
            }
        }
        
        System.out.println(answerMap);
        
        return answerMap.size();
    }
	
	public static class Village {
		int village;
		int distance;
		List<Road> roadList; 
		
		public Village(int v, int d, List<Road> roadList) {
			this.village = v;
			this.distance = d;
			this.roadList = roadList;
		}

		@Override
		public String toString() {
			return "Village [village=" + village + ", distance=" + distance + ", roadList=" + roadList + "]";
		}
		
		
	}
	
	public static class Road {
		
		int start;
		int end;
		int cost;
		
		public Road(int s, int e, int c) {
			this.start = s;
			this.end = e;
			this.cost = c;
		}

		@Override
		public String toString() {
			return "Road [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}

	}
}
