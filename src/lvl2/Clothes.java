package lvl2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clothes {

    public static void main(String[] args) {


    }

    public static int solution(String[][] clothes) {

        int answer = 0;

        final int _TYPE = 1;
        final int _NAME = 0;

        //의상 종류는 중요치 않음
        Map<String, Integer> typeMap = new HashMap<>();

        String clothType = "";
        for(String[] cloth : clothes) {
            clothType = cloth[_TYPE];
            if(typeMap.containsKey(clothType)) {
                typeMap.put(clothType, typeMap.get(clothType) + 1);
            } else {
                typeMap.put(clothType, 1);
            }
        }

        for (int count : typeMap.values()) {
            answer *= (count + 1); // 입지 않는 경우도 포함하기 위해 (+1)
        }
        return answer;
    }
}
