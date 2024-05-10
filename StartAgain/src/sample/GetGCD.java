package sample;

//최대공약수, 유클리드 호제법 : a와 b의 최대 공약수는 b와 a를 b로 나눈 나머지의 최대공약수와 같다

public class GetGCD {

	public static void main(String[] args) {
		
		int test = getGCD(2, 5);
		System.out.println(test);
	
	}
	
	public static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return getGCD(b, a%b);
    }
}
