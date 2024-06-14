package practice.lvl2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 호텔 대실 시간표
 * 
 * 호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 
 * 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
	예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때, 
	코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.
	
	제한사항
		1 ≤ book_time의 길이 ≤ 1,000
		book_time[i]는 ["HH:MM", "HH:MM"]의 형태로 이루어진 배열입니다
		[대실 시작 시각, 대실 종료 시각] 형태입니다.
		시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
		예약 시각이 자정을 넘어가는 경우는 없습니다.
		시작 시각은 항상 종료 시각보다 빠릅니다.
 * */
public class HotelSchedule_bak {

	public static void main(String[] args) {
		
		String[][] book_time = {
			{"10:00", "10:10"},
			{"10:20", "10:30"},
			{"10:40", "10:50"}
		};
		System.out.println(solution(book_time));
	}
	
	public static int solution(String[][] book_time) {

        List<BookingInfo> bookingInfoList = new ArrayList<BookingInfo>();
        
        for(String[] book : book_time) {
        	bookingInfoList.add(new BookingInfo(book));
        }
        
        Collections.sort(bookingInfoList, (o1, o2) -> o1.sortValue - o2.sortValue);
        
        //Room Queue List
        List<Queue<BookingInfo>> rqList = new ArrayList<Queue<BookingInfo>>();
        
        List<Integer> emptyRoomIdxList = new ArrayList<Integer>();
        
        Queue<BookingInfo> room = null;
        BookingInfo inRoom;
        Loop1:
        for(BookingInfo bi : bookingInfoList) {
        	if(rqList.size() == 0) {
        		rqList.add(bookNewRoom(bi));
        		continue;
        	}
        	
        	//현재 빈 방 찾기
        	emptyRoomIdxList.clear();
        	for(int i = 0; i < rqList.size(); i++) {
        		room = rqList.get(i);
        		if(room.isEmpty()) {
        			room.add(bi);
        			continue Loop1;
        		}
        		inRoom = room.peek();
        		
        		if(inRoom.finishCleanTime.equals(bi.inTime) || inRoom.finishCleanTime.isBefore(bi.inTime)) {
        			//방 비워~
        			room.poll();
        			emptyRoomIdxList.add(i);
        		}
        	}
        	
        	if(emptyRoomIdxList.isEmpty() || emptyRoomIdxList.size() == 0) {
        		rqList.add(bookNewRoom(bi));
        	} else {
        		rqList.get(emptyRoomIdxList.get(0)).add(bi);
        	}
        }
        
        return rqList.size();
    }
	
	public static Queue<BookingInfo> bookNewRoom(BookingInfo nowBook) {
		Queue<BookingInfo> room = new LinkedList<>();
		room.add(nowBook);
		
		return room;
	}
	
	public static class BookingInfo {
		int 		sortValue;
		LocalTime 	inTime;
		LocalTime 	outTime;
		LocalTime	finishCleanTime;
		
		public BookingInfo(String[] timeInfo) {
			
			this.sortValue = Integer.parseInt(timeInfo[0].replace(":", ""));
			this.inTime = LocalTime.of(Integer.parseInt(timeInfo[0].split(":")[0]), Integer.parseInt(timeInfo[0].split(":")[1]));
			this.outTime = LocalTime.of(Integer.parseInt(timeInfo[1].split(":")[0]), Integer.parseInt(timeInfo[1].split(":")[1]));
			this.finishCleanTime = outTime.plusMinutes(10);
		}
		
		public int getSortValue() {
			return sortValue;
		}
		public void setSortValue(int sortValue) {
			this.sortValue = sortValue;
		}
		public LocalTime getInTime() {
			return inTime;
		}
		public void setInTime(LocalTime inTime) {
			this.inTime = inTime;
		}
		public LocalTime getOutTime() {
			return outTime;
		}
		public void setOutTime(LocalTime outTime) {
			this.outTime = outTime;
		}
		public LocalTime getFinishCleanTime() {
			return finishCleanTime;
		}
		public void setFinishCleanTime(LocalTime finishCleanTime) {
			this.finishCleanTime = finishCleanTime;
		}
	}
}
