package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 순위 검색 
 * */
public class SearchRanking {

	public static void main(String[] args) {
		
		String[] info = {
				"java backend junior pizza 150"
				,"python frontend senior chicken 210"
				,"python frontend senior chicken 150"
				,"cpp backend senior pizza 260"
				,"java backend junior chicken 80"
				,"python backend senior chicken 50"
		};
		
		String[] query = {
				"java and backend and junior and pizza 100"
				,"python and frontend and senior and chicken 200"
				,"cpp and - and senior and pizza 250"
				,"- and backend and senior and - 150"
				,"- and - and - and chicken 100"
				,"- and - and - and - 150"
		};
		
		System.out.println(Arrays.toString(solution(info, query)));
	}
	
	static Map<String, Node> langMap 		= new HashMap<>();
	public static int[] solution(String[] info, String[] query) {
		
		List<Integer> answerList = new ArrayList<Integer>();
		
		setTree(info);
		
		String[] qr;
		ArrayList<Node> parents = new ArrayList<>();
		ArrayList<Node> children = new ArrayList<>();
		for(String q : query) {
			qr = q.split(" and ");
			//점수 조건은 무조건 있음 (foodNode 까지만 탐색)
			parents.clear();
			children.clear();
			for(int i = 0; i < qr.length; i++) {
				if(qr[i].split(" ")[0].equals("-")) {
					if(i == 0) {
						children.add(langMap.get("java"));
						children.add(langMap.get("python"));
						children.add(langMap.get("cpp"));
					} else {
						parents = new ArrayList<>(children);
						children.clear();
						for(int j = 0; j < parents.size(); j++) {
							if(parents.get(j).getLeftNode() != null) {
								children.add(parents.get(j).getLeftNode());
							}
							if(parents.get(j).getRightNode() != null) {
								children.add(parents.get(j).getRightNode());
							}
						}
					}
					
				} else {
					if(i == 0) {
						children.add(langMap.get(qr[i]));
					} else {
						parents = new ArrayList<>(children);
						children.clear();
						for(int j = 0; j < parents.size(); j++) {
							if(parents.get(j).findNodeByValue(qr[i].split(" ")[0]) != null) {
								children.add(parents.get(j).findNodeByValue(qr[i].split(" ")[0]));
							}
						}
					}
				}
			}
			
			// foodNode 에 저장된 점수 정보 확인
			if(!children.isEmpty()) {
				int cnt = 0;
				for(Node n : children) {
					if(n.getScore() != null) {
						
						for(int s = 0; s < n.getScore().size(); s++) {
							if(n.getScore().get(s) >= Integer.parseInt(qr[3].split(" ")[1])) {
								cnt++;
							}
						}
					}
				}
				answerList.add(cnt);
				
			} else {
				answerList.add(0);
			}
		}
		
		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void setTree(String[] info) {
		Node java 	= new Node(1, "java");
		Node python = new Node(1, "python");
		Node cpp 	= new Node(1, "cpp");
		
		langMap.put("java", java);
		langMap.put("python", python);
		langMap.put("cpp", cpp);
		
		String[] pi;
		Node langNode 	= null;
		Node jobNode	= null;
		Node carrNode = null;
		Node foodNode	= null;
		for(String person : info) {
			
			pi = person.split(" ");
			langNode = langMap.get(pi[0]);
			langNode.plusCount();
			
			//2depth
			if(langNode.getLeftNode() == null) {
				langNode.setLeftNode(new Node(2, "backend"));
			}
			if(langNode.getRightNode() == null) {
				langNode.setRightNode(new Node(2, "frontend"));
			}
			
			if((pi[1]).equals(langNode.getLeftNode().getValue())) {
				jobNode = langNode.getLeftNode();
				
			} else if((pi[1]).equals(langNode.getRightNode().getValue())) {
				jobNode = langNode.getRightNode();
			} 
			jobNode.plusCount();
			
			//3depth
			if(jobNode.getLeftNode() == null) {
				jobNode.setLeftNode(new Node(3, "junior"));
			}
			if(jobNode.getRightNode() == null) {
				jobNode.setRightNode(new Node(3, "senior"));
			}
			
			if((pi[2]).equals(jobNode.getLeftNode().getValue())) {
				carrNode = jobNode.getLeftNode();
			} else if((pi[2]).equals(jobNode.getRightNode().getValue())) {
				carrNode = jobNode.getRightNode();
			}
			carrNode.plusCount();
			
			//4depth
			if(carrNode.getLeftNode() == null) {
				carrNode.setLeftNode(new Node(4, "chicken"));
			}
			if(carrNode.getRightNode() == null) {
				carrNode.setRightNode(new Node(4, "pizza"));
			}
			
			if((pi[3]).equals(carrNode.getLeftNode().getValue())) {
				foodNode = carrNode.getLeftNode();
			} else if((pi[3]).equals(carrNode.getRightNode().getValue())) {
				foodNode = carrNode.getRightNode();
			}
			foodNode.plusCount();
			
			if(foodNode.getScore() == null) {
				foodNode.setScore(new ArrayList<Integer>());
			}
			
			foodNode.getScore().add(Integer.parseInt(pi[4]));
		}
	}
	
	public static class Node {
		
		int level;		//계층 
		String value;	//값 
		int count;

		ArrayList<Integer> score;
		
		Node leftNode;	//아래 노드
		Node rightNode; //우측 노드
		
		public void plusCount() {
			this.count++;
		}
		public Node findNodeByValue(String value) {
			
			if(this.getLeftNode() != null && 
					value.equals(this.getLeftNode().getValue())) return this.getLeftNode();
			if(this.getRightNode() != null && 
					value.equals(this.getRightNode().getValue())) return this.getRightNode();
			else return null;
			
		}
		
		
		public Node(int lvl, String val) {
			
			this.level = lvl;
			this.value = val;
			this.count = 0;
		}
		
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}

		public ArrayList<Integer> getScore() {
			return score;
		}

		public void setScore(ArrayList<Integer> score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return "Node [level=" + level + ", value=" + value + ", count=" + count + ", score=" + score + ", leftNode="
					+ leftNode + ", rightNode=" + rightNode + "]";
		}
	}
}

