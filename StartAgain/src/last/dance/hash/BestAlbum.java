package last.dance.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbum {

	public static void main(String[] args) {
		
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		List<Integer> answerList = new ArrayList<>();
		
		/**
		 * 	속한 노래가 많이 재생된 장르를 먼저 수록합니다.
			장르 내에서 많이 재생된 노래를 먼저 수록합니다.
			장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
			장르 당 두곡
		 * */
		
		//장르 맵
		Map<String, Integer> gMap = new HashMap<>();
		
		//장르별 음악 맵
		Map<String, List<Song>> sMap = new HashMap<>();
		
		List<Song> tempList;
		for(int i = 0; i < genres.length; i++) {
			
			gMap.put(genres[i], gMap.getOrDefault(genres[i], 0) + plays[i]);
			
			tempList = sMap.getOrDefault(genres[i], new ArrayList<Song>());
			tempList.add(new Song(i, plays[i]));
			sMap.put(genres[i], tempList);
		}
		
		//많이 재생된 장르 순 정렬
		List<Entry<String, Integer>> gEntry = new ArrayList<>(gMap.entrySet());
		gEntry.sort((o1, o2) -> o2.getValue() - o1.getValue());
		
		
		//강 장르 별 최다 재생 2곡 추출
		for(Entry<String, Integer> e : gEntry) {
			
			tempList = sMap.get(e.getKey());
			//많이 재생된 순 정렬
			tempList.sort((o1, o2) -> {
				int compare = o2.getPlayCnt() - o1.getPlayCnt();
				if(compare == 0) {
					return o1.getSongId() - o2.getSongId();
				}
				return compare;
			});

			int cnt = 0;
			while(cnt < 2 && tempList.size() > cnt) {
				answerList.add(tempList.get(cnt++).getSongId());
			}
		}
		
		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static class Song {
		private int songId;
		private int playCnt;
		
		public Song(int songId, int playCnt) {
			super();
			this.songId = songId;
			this.playCnt = playCnt;
		}
		public int getSongId() {
			return songId;
		}
		public void setSongId(int songId) {
			this.songId = songId;
		}
		public int getPlayCnt() {
			return playCnt;
		}
		public void setPlayCnt(int playCnt) {
			this.playCnt = playCnt;
		}
		@Override
		public String toString() {
			return "Song [songId=" + songId + ", playCnt=" + playCnt + "]";
		}
		
		
	}
}
