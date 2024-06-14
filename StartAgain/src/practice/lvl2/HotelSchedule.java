package practice.lvl2;

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
public class HotelSchedule {

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
        
        Collections.sort(bookingInfoList, (o1, o2) -> o1.inMin - o2.inMin);
        
        List<Queue<BookingInfo>> rqList = new ArrayList<Queue<BookingInfo>>();
        BookingInfo nowBook;
        Loop1:
        for(BookingInfo bi : bookingInfoList) {
        	
        	if(rqList.isEmpty()) {
        		rqList.add(bookNewRoom(bi));
        		continue;
        	}

        	for(Queue<BookingInfo> room : rqList) {
        		nowBook = room.peek();
        		if(nowBook.getOutMin() <= bi.getInMin()) {
        			room.poll();
        			room.add(bi);
        			continue Loop1;
        		}
        	}
        	
        	rqList.add(bookNewRoom(bi));
        }
        
        return rqList.size();
    }
	
	public static Queue<BookingInfo> bookNewRoom(BookingInfo nowBook) {
		Queue<BookingInfo> room = new LinkedList<>();
		room.add(nowBook);
		
		return room;
	}
	
	public static class BookingInfo {
		int	inMin;
		int outMin; //청소 시간 포함
		
		public BookingInfo(String[] book) {
			this.inMin = Integer.parseInt(book[0].split(":")[0]) * 60 + Integer.parseInt(book[0].split(":")[1]);
			this.outMin = Integer.parseInt(book[1].split(":")[0]) * 60 + Integer.parseInt(book[1].split(":")[1]) + 10;
		}

		public int getInMin() {
			return inMin;
		}

		public void setInMin(int inMin) {
			this.inMin = inMin;
		}

		public int getOutMin() {
			return outMin;
		}

		public void setOutMin(int outMin) {
			this.outMin = outMin;
		}

		@Override
		public String toString() {
			return "BookingInfo [inMin=" + inMin + ", outMin=" + outMin + "]";
		}
	}
}
