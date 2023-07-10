package lv0;

import java.util.Scanner;

public class VerticalString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        for(char c : input.toCharArray()) {
            System.out.println(c);
        }
    }
}
