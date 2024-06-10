package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 카카오톡 오픈채팅방에서는 친구가 아닌 사람들과 대화를 할 수 있는데, 본래 닉네임이 아닌 가상의 닉네임을 사용하여 채팅방에 들어갈 수 있다.

	신입사원인 김크루는 카카오톡 오픈 채팅방을 개설한 사람을 위해, 다양한 사람들이 들어오고, 나가는 것을 지켜볼 수 있는 관리자창을 만들기로 했다. 
	채팅방에 누군가 들어오면 다음 메시지가 출력된다.

		"[닉네임]님이 들어왔습니다."
		
		채팅방에서 누군가 나가면 다음 메시지가 출력된다.
		
		"[닉네임]님이 나갔습니다."
		
		채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.
		
		채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
		채팅방에서 닉네임을 변경한다.
		닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다.

	예를 들어, 채팅방에 "Muzi"와 "Prodo"라는 닉네임을 사용하는 사람이 순서대로 들어오면 채팅방에는 다음과 같이 메시지가 출력된다.
	채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 
	모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
 * */
public class OpenChatting {

	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	
	public static String[] solution(String[] record) {
        String[] answer = {};
        
        // ID, Nickname
        Map<String, String> uidMap = new HashMap<String, String>();
        
        // ID, Action
        List<ActHistory> actList = new ArrayList<>();
        
        String[] actArr;
        for(String action : record) {
        	actArr = action.split(" ");
        	
        	if(actArr[0].equals("Enter")) {
        		// 입장
        		actList.add(new ActHistory(actArr[1], actArr[0]));
        		uidMap.put(actArr[1], actArr[2]);
        		
        	} else if(actArr[0].equals("Leave")) {
        		// 퇴장
        		actList.add(new ActHistory(actArr[1], actArr[0]));
        		
        	} else if(actArr[0].equals("Change")) {
        		// 닉네임 변경
        		uidMap.put(actArr[1], actArr[2]);
        	}
        }

        answer = new String[actList.size()];
        ActHistory act = null;
        for(int i = 0; i < actList.size(); i++) {
        	act = actList.get(i);
        	answer[i] = act.getHistoryMessage(uidMap.get(act.uid));
        }
        
        return answer;
    }
	
	public static class ActHistory {
		String uid;
		String action;
		
		public ActHistory (String uid, String action) {
			this.uid = uid;
			this.action = action;
		}
		
		public String getHistoryMessage(String nickname) {
			StringBuffer sbf = new StringBuffer();
			sbf.append(nickname);
			sbf.append("님이 ");
			switch(this.action) {
			case "Enter":
				sbf.append("들어왔습니다.");
				break;
			case "Leave" :
				sbf.append("나갔습니다.");
				break;
			default:
				break;
			}
			return sbf.toString();
		}
		
		@Override
		public String toString() {
			return "ActHistory [uid=" + uid + ", action=" + action + "]";
		}
	}
}
