package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 파일명 정렬
 * 
 * 소스 파일 저장소에 저장된 파일명은 100 글자 이내로, 
 * 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다. 
 * 파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.

	파일명은 크게 HEAD, NUMBER, TAIL의 세 부분으로 구성된다.
	
	HEAD는 숫자가 아닌 문자로 이루어져 있으며, 최소한 한 글자 이상이다.
	NUMBER는 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있으며, 
	앞쪽에 0이 올 수 있다. 0부터 99999 사이의 숫자로, 00000이나 0101 등도 가능하다.
	TAIL은 그 나머지 부분으로, 여기에는 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.
	
	파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다. 이때, 문자열 비교 시 대소문자 구분을 하지 않는다. MUZI와 muzi, MuZi는 정렬 시에 같은 순서로 취급된다.
	파일명의 HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬한다. 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬된다. 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
	두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다. MUZI01.zip과 muzi1.png가 입력으로 들어오면, 정렬 후에도 입력 시 주어진 두 파일의 순서가 바뀌어서는 안 된다.
 * */
public class SortFiles {

	public static void main(String[] args) {
		
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		
		System.out.println(Arrays.toString(solution(files)));
	}
	
	public static String[] solution(String[] files) {

		List<String> answerList = new ArrayList<String>();
        List<FileInfo> fileList = new ArrayList<FileInfo>();
        for(int i = 0; i < files.length; i++) {
        	
        	fileList.add(new FileInfo(files[i], i));
        }
        
        Collections.sort(fileList, new FileComparator());
        
        for(FileInfo fi : fileList) {
        	answerList.add(fi.fullName);
        }
        
        return answerList.stream().toArray(String[]::new);
    }
	
	static class FileComparator implements Comparator<FileInfo> {

		@Override
		public int compare(FileInfo o1, FileInfo o2) {
			
			if(o1.headPart.compareTo(o2.headPart) == 0) {
				
				if(o1.realNumber - o2.realNumber == 0) {
					return o1.ognOrder - o2.ognOrder;
				} else {
					return o1.realNumber - o2.realNumber;
				}
				
			} else {
				return o1.headPart.compareTo(o2.headPart);
			}
			
		}
    }
	
	static class FileInfo {
		
		String fullName;
		String headPart;
		String numberPart;
		String tailPart;
		
		int ognOrder;
		int realNumber;
		
		public FileInfo(String fileName, int order) {
			
			this.fullName = fileName;
			this.ognOrder = order;
			
			StringBuffer sbf = new StringBuffer(); 
		
			for(char c : fileName.toCharArray()) {
				
				if (Character.isDigit(c) && this.headPart == null) {
					headPart = sbf.toString().toUpperCase();
					sbf.setLength(0);
					
				} else if (!Character.isDigit(c) 
						&& this.headPart != null
						&& this.numberPart == null) {
					numberPart = sbf.toString().toUpperCase();
					sbf.setLength(0);
					
				}
				sbf.append(c);
			}
			if(numberPart == null ) {
				numberPart = sbf.toString();
			} else {
				tailPart = sbf.toString().toUpperCase();
			}
			
			realNumber = Integer.parseInt(numberPart);
		}

		@Override
		public String toString() {
			return "FileInfo [fullName=" + fullName + ", headPart=" + headPart + ", numberPart=" + numberPart
					+ ", tailPart=" + tailPart + ", ognOrder=" + ognOrder + ", realNumber=" + realNumber + "]";
		}
	}
}
