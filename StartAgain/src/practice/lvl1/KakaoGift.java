package practice.lvl1;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * 선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다. 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.

	두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
	예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
	두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
	선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
	예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 
	만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
	만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
	위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.
	
	친구들의 이름을 담은 1차원 문자열 배열 friends 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가 매개변수로 주어집니다. 
	이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.
 * 
 * */
public class KakaoGift {

	
	public static void main(String[] args) {
		
		String[] friends 	= {"joy", "brad", "alessandro", "conan", "david"};
		String[] gifts		= {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
		
		System.out.println(solution(friends, gifts));
	}
	
	public static int solution(String[] friends, String[] gifts) {
		
        int answer = 0;
        
        Map<String, Person> personMap = new HashMap<String, Person>();
        
        for(String name : friends) {
        	personMap.put(name, new Person(name));
        }
        
        String sender 	= "";
        String receiver	= "";
        Person sp = null;
        Person rp = null;
        for(String hst : gifts) {
        	
        	sender 		= hst.split(" ")[0];
        	receiver 	= hst.split(" ")[1];
        	
        	sp = personMap.get(sender);
        	rp = personMap.get(receiver);
        	
        	sp.point++;
        	rp.point--;
        	
        	sp.sendMap.put(receiver, sp.sendMap.get(receiver) == null ? 1 : sp.sendMap.get(receiver) + 1);
        }
        
        Person p1 = null;
        Person p2 = null;
        
        int p1Send = 0;
        int p2Send = 0;
        
        for(int i = 0; i < friends.length - 1; i++) {
        	
        	for(int j = i; j < friends.length; j++) {
        		p1 = personMap.get(friends[i]);
        		p2 = personMap.get(friends[j]);
        		
        		p1Send = p1.sendMap.get(p2.name) == null ? 0 : p1.sendMap.get(p2.name);
        		p2Send = p2.sendMap.get(p1.name) == null ? 0 : p2.sendMap.get(p1.name);
        		
        		//1. 상호간에 선물 많이 보낸 사람이 받음
        		if(p1Send > p2Send) p1.receive++;
        		else if(p2Send > p1Send) p2.receive++;
        		else {
        			//2. 기록이 없거나, 동일하게 주고 받았다면, 선물 지수가 큰 사람이 받음
        			if(p1.point > p2.point) p1.receive++;
        			else if(p2.point > p1.point) p2.receive++;
        			else {
        				//3. 지수도 같다면 pass
        				continue;
        			}
        		}
        	}
        }
        
        for(String name : friends) {
        	if(answer < personMap.get(name).receive) answer = personMap.get(name).receive; 
        }
        
        return answer;
    }

	
	public static class Person {
		
		String name;
		int point;			//지수 : 이번달까지 보낸 선물 수 - 받은 선물 수
		Map<String, Integer> sendMap = new HashMap<String, Integer>();	//보낸 선물 Map
		
		int receive;		//이번 달 수령예정 선물 수
		
		public Person(String name) {
			this.name = name;
			this.point = 0;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", point=" + point + ", sendMap=" + sendMap 
					+ ", receive=" + receive + "]";
		}
	}
}
