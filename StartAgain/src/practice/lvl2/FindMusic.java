package practice.lvl2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 방금 그곡
 * 
 * 라디오를 자주 듣는 네오는 라디오에서 방금 나왔던 음악이 무슨 음악인지 궁금해질 때가 많다. 
 * 그럴 때 네오는 다음 포털의 '방금그곡' 서비스를 이용하곤 한다. 방금그곡에서는 TV, 라디오 등에서 나온 음악에 관해 제목 등의 정보를 제공하는 서비스이다.

	네오는 자신이 기억한 멜로디를 가지고 방금그곡을 이용해 음악을 찾는다. 
	그런데 라디오 방송에서는 한 음악을 반복해서 재생할 때도 있어서 네오가 기억하고 있는 멜로디는 음악 끝부분과 처음 부분이 이어서 재생된 멜로디일 수도 있다. 
	반대로, 한 음악을 중간에 끊을 경우 원본 음악에는 네오가 기억한 멜로디가 들어있다 해도 그 곡이 네오가 들은 곡이 아닐 수도 있다. 
	그렇기 때문에 네오는 기억한 멜로디를 재생 시간과 제공된 악보를 직접 보면서 비교하려고 한다. 다음과 같은 가정을 할 때 네오가 찾으려는 음악의 제목을 구하여라.
	
	방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
	네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
	각 음은 1분에 1개씩 재생된다. 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다. 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
	음악이 00:00를 넘겨서까지 재생되는 일은 없다.
	조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
	조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
	입력 형식
	입력으로 네오가 기억한 멜로디를 담은 문자열 m과 방송된 곡의 정보를 담고 있는 배열 musicinfos가 주어진다.
	
	m은 음 1개 이상 1439개 이하로 구성되어 있다.
	musicinfos는 100개 이하의 곡 정보를 담고 있는 배열로, 각각의 곡 정보는 음악이 시작한 시각, 끝난 시각, 음악 제목, 악보 정보가 ','로 구분된 문자열이다.
	음악의 시작 시각과 끝난 시각은 24시간 HH:MM 형식이다.
	음악 제목은 ',' 이외의 출력 가능한 문자로 표현된 길이 1 이상 64 이하의 문자열이다.
	악보 정보는 음 1개 이상 1439개 이하로 구성되어 있다.
	
	"ABCDEFG"	["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"HELLO"
 * */
public class FindMusic {

	public static void main(String[] args) {
	
		String m = "CC#BCC#B";
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}	;
		
		System.out.println(solution(m, musicinfos));
	}
	
	public static String solution(String m, String[] musicinfos) {

        //들은 음악(m)을 계이름 단위로 변환
		List<String> heard = new ArrayList<>();
		StringBuffer sbf = new StringBuffer(); 
		for(int i = 0; i < m.length(); i++) {
			sbf.setLength(0);
			sbf.append(m.charAt(i));
			if(i < m.length() - 1 &&  m.charAt(i + 1) == '#') {
				sbf.append(m.charAt(i + 1));
				i += 1;
			}
			heard.add(sbf.toString());
		}
		
		//라디오에서 재생된 음악 리스트
		List<MusicInfo> musicList = new ArrayList<MusicInfo>();
        for(int i = 0; i < musicinfos.length; i++) {
        	musicList.add(new MusicInfo(i, musicinfos[i].split(",")));
        }
        
        //일치하는 음악을 담을 리스트 (여러 음악일 수 있음)
  		List<MusicInfo> answerList = new ArrayList<MusicInfo>();
  		
  		//재생된 음악 악보
        List<String> playedMusic = new ArrayList<String>();
        
        //곡 확인
        int idx, time;
        for(MusicInfo mi : musicList) {
        	idx = 0;
        	time = 0;
        	playedMusic.clear();
        	while(time < mi.playMinutes) {
        		
        		playedMusic.add(mi.musicBookList.get(idx));
        		idx 	+= 1;
        		time 	+= 1;
        		
        		if(idx == mi.musicBookList.size()) idx = 0;
        	}
        	
        	//재생된 음악이 들은 음악을 포함하고 있는지 확인
        	if(Collections.indexOfSubList(playedMusic, heard) > -1) {
        		answerList.add(mi);
        	}
        }
        
        if(answerList.size() == 0) return "(None)";
        if(answerList.size() > 1) {
        	Collections.sort(answerList, new MusicComparator());
        }
        return answerList.get(0).title;
    }
	
	public static class MusicComparator implements Comparator<MusicInfo> {

		/**
		 * 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 
		 * 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
		 * 
		 * playMinutes 내림차순
		 * index 오름차순
		 * */
		@Override
		public int compare(MusicInfo o1, MusicInfo o2) {
			
			int playTime = o2.playMinutes - o1.playMinutes;
			if(playTime == 0) {
				return o1.index - o2.index;
			}
			return playTime;
		}
		
	}
	
	public static class MusicInfo {
		int 		index;
		String 		title;
		String 		musicBook;
		LocalTime 	startTime;
		LocalTime 	endTime;
		int 		playMinutes;
		int			playCount;
		
		List<String> musicBookList;
		
		public MusicInfo(int idx, String[] music) {
			
			this.index		= idx;
			
			this.title		= music[2];
			this.musicBook 	= music[3];
			this.startTime 	= LocalTime.of(Integer.parseInt(music[0].split(":")[0]), Integer.parseInt(music[0].split(":")[1]));
			this.endTime	= LocalTime.of(Integer.parseInt(music[1].split(":")[0]), Integer.parseInt(music[1].split(":")[1]));
			
			this.musicBookList = setMusicBookArr();
			this.playMinutes = (int) Duration.between(startTime, endTime).toMinutes();
			this.playCount	= (int) Math.ceil((double)playMinutes/musicBookList.size());
		}

		private List<String> setMusicBookArr() {
			
			List<String> list = new ArrayList<>();
			StringBuffer sbf = new StringBuffer(); 
			
			for(int i = 0; i < this.musicBook.length(); i++) {
				sbf.setLength(0);
				sbf.append(musicBook.charAt(i));
				if(i < musicBook.length() - 1 &&  musicBook.charAt(i + 1) == '#') {
					sbf.append(musicBook.charAt(i + 1));
					i += 1;
				}
				list.add(sbf.toString());
			}
			return list;
		}

		@Override
		public String toString() {
			return "MusicInfo [index=" + index + ", title=" + title + ", musicBook=" + musicBook + ", startTime="
					+ startTime + ", endTime=" + endTime + ", playMinutes=" + playMinutes + ", playCount=" + playCount
					+ ", musicBookList=" + musicBookList + "]";
		}

	}
}
