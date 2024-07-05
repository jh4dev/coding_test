package practice.lvl3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 단어 변환
 * */
public class ChangeWord {

	public static void main(String[] args) {
		
		String begin = "hot";
		String target = "dog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		System.out.println(solution(begin, target, words));
	}
	
	public static int solution(String begin, String target, String[] words) {

        Map<String, Integer> cntMap = new HashMap<>();
        for(String word : words) {
        	cntMap.put(word, 0);
        }
        if(cntMap.get(target) == null) return 0;
        Queue<String> wordQueue = new LinkedList<String>();
        wordQueue.add(begin);
        
        String nowWord = "";
        boolean[] visited = new boolean[words.length];
        while(!wordQueue.isEmpty()) {
        	
        	nowWord = wordQueue.poll();
        	
        	if(target.equals(nowWord)) break;
        	
        	for(int i = 0; i < words.length; i++) {
        		if(!visited[i] && isDiffrentOnlyOneCharracter(nowWord, words[i])) {
        			wordQueue.add(words[i]);
        			int nowCnt 	= cntMap.getOrDefault(nowWord, 0);
        			
        			cntMap.put(words[i], nowCnt + 1);
        			visited[i] = true;
        		}
        	}
        }
        
        return cntMap.get(target) < Integer.MAX_VALUE ? cntMap.get(target) : 0;
    }
	
	public static boolean isDiffrentOnlyOneCharracter(String s1, String s2) {
		int diff = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) diff++;
		}
		return diff == 1 ? true : false;
	}
}
