package lv0;

import java.util.Scanner;

public class CapitalSmall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        StringBuffer bf = new StringBuffer();
        for(char c : a.toCharArray()) {
            if(c >= 'A' && c <= 'Z') {
                //대문자 -> 소문자
                c += 32;
            } else if(c >= 'a' && c <= 'z') {
                //소문자 -> 대문자
                c -= 32;
            }
            bf.append(c);
        }
        System.out.println(bf);


    }

}
