package practice.lvl1;

/**
 * 	1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 * */
public class RecommandNewId {

	public static void main(String[] args) {

		String newId = "1234567890.123.456";
		
		System.out.println(solution(newId));
		
	}
	
	public static String solution(String new_id) {
		
		String rc = "";
		
		//1단계
		rc = new_id.toLowerCase();
		
		
		//2단계
		//정규식
//		String expr = new_id.replaceAll("[^a-z0-9-_\\.]", "");
		for(int i = 0; i < new_id.length(); i++) {
			if(!(Character.isAlphabetic(new_id.charAt(i))
				|| Character.isDigit(new_id.charAt(i)) 
				|| new_id.charAt(i) == '-'
				|| new_id.charAt(i) == '_'
				|| new_id.charAt(i) == '.')
				) {
				rc = rc.replaceAll("\\"+String.valueOf(new_id.charAt(i)), "");
			}
		}

		//3단계
		while(rc.indexOf("..") >= 0) {
			rc = rc.replaceAll("\\.\\.", "\\.");
		}
		
		
		//4단계
		if(rc.indexOf(".") == 0) {
			rc = rc.substring(1);
		}
		if(!rc.isEmpty() && rc.lastIndexOf(".") == rc.length() - 1) {
			rc = rc.substring(0, rc.length() -1);
		}
		
		//5단계
		if(rc.isEmpty()) rc = "a";
		
		//6단계
		if(rc.length() >= 16) {
			rc = rc.substring(0, 15);
			if(!rc.isEmpty() && rc.lastIndexOf(".") == rc.length() - 1) {
				rc = rc.substring(0, rc.length() -1);
			}
		}
		
		//7단계
		if(rc.length() < 3) {
			while(true) {
				rc += rc.substring(rc.length() - 1);
				if(rc.length() == 3) break;
			}
		}
		
		return rc;
	}
}
