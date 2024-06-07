package practice.lvl2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 주차 요금
 * 
 * 제약조건
 * 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
	0000번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.
	00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
	누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
	누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
	초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
	⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다.
	주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 
	차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 * */
public class ParkingFee {

	public static void main(String[] args) {
		
		int[] fees = {180, 5000, 10, 600};
		String[] records = {
				"05:34 5961 IN", 
				"06:00 0000 IN", 
				"06:34 0000 OUT", 
				"07:59 5961 OUT", 
				"07:59 0148 IN", 
				"18:59 0000 IN", 
				"19:09 0148 OUT", 
				"22:59 5961 IN", 
				"23:00 5961 OUT"};
		
		System.out.println(Arrays.toString(solution(fees, records)));
	}
	
	public static int[] solution(int[] fees, String[] records) {

		Map<String, ParkInfo> parkMap = new HashMap<String, ParkInfo>();
        
        String[] parking;
        ParkInfo pi = null;
        for(String r : records) {
        	parking = r.split(" ");
        	pi = parkMap.get(parking[1]);
        	if("IN".equals(parking[2])) {
        		if(pi == null) {
        			parkMap.put(parking[1], new ParkInfo(parking[1], parking[0]));
        		} else {
        			//재진입
        			pi.setReEnterInfo(parking[0]);
        			parkMap.put(parking[1], pi);
        		}
        	} else {
        		pi = parkMap.get(parking[1]);
        		pi.setOutTimeAndStayMinutes(parking[0]);
        		parkMap.put(parking[1], pi);
        	}
        }
        
        
        /*	< fees > 요금
         * 	fees[0] = 기본 시간(분)
				1 ≤ fees[0] ≤ 1,439
			fees[1] = 기본 요금(원)
				0 ≤ fees[1] ≤ 100,000
			fees[2] = 단위 시간(분)
				1 ≤ fees[2] ≤ 1,439
			fees[3] = 단위 요금(원)
				1 ≤ fees[3] ≤ 10,000
         * */
        
        List<ParkInfo> piList = new ArrayList<>();
        double otm = 0;
        for(Map.Entry<String, ParkInfo> entry : parkMap.entrySet()) {
        	
        	pi = entry.getValue();
        	pi.checkOutYnAndsetDefaultOutTime();
        	//기본요금
        	pi.fee = fees[1];
        	if(pi.stayMinutes > fees[0]) {
        		otm = pi.stayMinutes - fees[0];
        		pi.fee += ((int)Math.ceil(otm / fees[2]) * fees[3]);
        	}
        	piList.add(pi);
        }
        
        piList.sort((o1, o2) -> Integer.parseInt(o1.carNo) - Integer.parseInt(o2.carNo));
        int[] answer = new int[piList.size()];
        
        for(int i = 0; i < piList.size(); i++) {
        	answer[i] = piList.get(i).fee;
        }
        
        return answer;
    }
	
	
	static class ParkInfo {
		
		String carNo;
		LocalTime inTime;
		LocalTime outTime;
		
		int fee;
		int stayMinutes = 0;
		
		public ParkInfo(String carNo, String inTimeStr) {
			this.carNo 	= carNo;
			this.inTime = LocalTime.of(Integer.parseInt(inTimeStr.split(":")[0]), Integer.parseInt(inTimeStr.split(":")[1]));
		}
		
		public void setReEnterInfo(String inTimeStr) {
			this.inTime = LocalTime.of(Integer.parseInt(inTimeStr.split(":")[0]), Integer.parseInt(inTimeStr.split(":")[1]));
			this.outTime = null;
		}
		
		public void setOutTimeAndStayMinutes(String outTimeStr) {
			this.outTime = LocalTime.of(Integer.parseInt(outTimeStr.split(":")[0]), Integer.parseInt(outTimeStr.split(":")[1]));
	        this.stayMinutes += (int) ChronoUnit.MINUTES.between(this.inTime, this.outTime);
		}
		
		public void checkOutYnAndsetDefaultOutTime() {
			if(this.outTime == null) {
				this.outTime = LocalTime.of(23, 59);
				this.stayMinutes += (int) ChronoUnit.MINUTES.between(this.inTime, this.outTime);
			}
		}

		@Override
		public String toString() {
			return "ParkInfo [carNo=" + carNo + ", inTime=" + inTime + ", outTime=" + outTime + ", fee=" + fee
					+ ", stayMinutes=" + stayMinutes + "]";
		}
	}
}
