package practice.lvl3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {

	public static void main(String[] args) {
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
	
	public static int[] solution(String[] genres, int[] plays) {

		List<Integer> answerList = new ArrayList<>();
        /**
         * 	1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
			2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
			3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
			
         * */
        
        Map<String, Integer> 		gMap = new HashMap<>();
        Map<String, List<Song>> 	sMap = new HashMap<>();
        
        List<Song> temp;
        for(int i = 0; i < genres.length; i++) {
        	gMap.put(genres[i], gMap.getOrDefault(genres[i], 0) + plays[i]);

        	temp = sMap.getOrDefault(genres[i], new ArrayList<>());
        	temp.add(new Song(i, plays[i]));
        	
        	sMap.put(genres[i], temp);
        }
        
        //map entry to entry list
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(gMap.entrySet());
        genreList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        String genre;
        int index = 0;
        for(int i = 0; i < genreList.size(); i++) {
        	//genre
        	genre = genreList.get(i).getKey();
        	
        	temp = sMap.get(genre);
        	temp.sort((o1, o2) -> o2.playCnt - o1.playCnt);
        	//수록카운트 겸용
        	index = 0;
        	while(index < 2 && index < temp.size()) {
        		answerList.add(temp.get(index).getIdx());
        		index++;
        	}
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static class Song {
		private int idx;
		private int playCnt;
		
		public Song(int idx , int playCnt) {
			this.idx = idx;
			this.playCnt = playCnt;
		}
		
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public int getPlayCnt() {
			return playCnt;
		}
		public void setPlayCnt(int playCnt) {
			this.playCnt = playCnt;
		}
		@Override
		public String toString() {
			return "Song [idx=" + idx + ", playCnt=" + playCnt + "]";
		}
	}
}
