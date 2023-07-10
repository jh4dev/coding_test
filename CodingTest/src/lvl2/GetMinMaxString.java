package lvl2;

import java.util.ArrayList;
import java.util.List;

public class GetMinMaxString {
    public String getMinMaxString(String str) {

        String[] arrStr = str.split(" ");

        List<Integer> list = new ArrayList<>();
        for(String ele : arrStr) {
            list.add(Integer.parseInt(ele));
        }

        list.sort((o1, o2) -> o1 - o2);

        return list.get(0) + " " + list.get(arrStr.length - 1);
    }

    public static void main(String[] args) {
        String str = "-1 -2 -3 -4";
        GetMinMaxString minMax = new GetMinMaxString();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println("최대값과 최소값은?" + minMax.getMinMaxString(str));
    }
}
