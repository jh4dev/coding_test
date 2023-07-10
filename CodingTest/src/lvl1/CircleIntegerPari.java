package lvl1;
public class CircleIntegerPari {

    public static void main(String[] args) {

        int r1 = 2;
        int r2 = 3;

        System.out.println(solution(r1, r2));
    }

    private static long solution(int r1, int r2) {

        long answer = 0;

        //1사분면 계산
        for(int i = 1; i < r2; i++) {

            if(i < r1) {
                answer += (getY(false, r2, i) - getY(true, r1, i));
            } else {
                answer += getY(false, r2, i);
            }
        }

        //4사분면 내 포인트 계산
        answer *= 4;
        //각 좌표선 내 포인트 계산
        answer += (r2 - r1 + 1) * 4;


        return answer;
    }

    private static int getY(boolean isR1, long radius, long x) {

        double dbY = Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
        int intY = (int) dbY;

        if(isR1 && dbY - intY == 0.0) {
            //내부 원의 원주에 정수 포인트가 있는 경우 처리
            return intY - 1;
        } else {
            return intY;
        }
    }
}
