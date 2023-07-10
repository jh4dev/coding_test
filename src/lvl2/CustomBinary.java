package lvl2;

import java.util.Arrays;

public class CustomBinary {

    public static void main(String[] args) {

        String str = "110010101001";
        System.out.println(str.length());
        System.out.println(str.replaceAll("0", "").length());

        System.out.println(Arrays.toString(solution(str)));
    }

    public static int[] solution(String s) {

        final String _ZERO = "0";
        final String _ONE = "1";

        int loop = 0;
        int removeCnt = 0;

        while(!_ONE.equals(s)){
            removeCnt += (s.length() - s.replaceAll(_ZERO, "").length());
            s = s.replaceAll(_ZERO, "");
            s = Integer.toBinaryString(s.length());
            loop++;
        }

        return new int[]{loop, removeCnt};
    }

}
