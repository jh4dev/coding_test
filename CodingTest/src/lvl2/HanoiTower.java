//package lvl2;
//
//import java.util.*;
//
//public class HanoiTower {
//
//    public static void main(String[] args) {
//
//
//    }
//
//    public static int[][] solution(int n) {
//
//        List<int[]> answerList = new ArrayList<>();
//
//        final int _FIRST = 0;
//        final int _SECOND = 1;
//        final int _THIRD = 2;
//
//        //기둥 셋팅
//        List<Stack<Integer>> pillarList = new ArrayList<>();
//        for(int i = 0; i < 3; i++) {
//
//            Stack<Integer> pillar = new Stack<>();
//            //첫번째 기둥 고리 셋팅
//            if(i == 0) {
//                for(int j = 1; j <= n; j++) {
//                    pillar.push(j);
//                }
//            }
//            pillarList.add(pillar);
//        }
//
//        int source = 0;
//        int target = 0;
//        int hand = 0;
//
//        while(true) {
//            if(pillarList.get(_THIRD).size() == n) {
//                break;
//            }
//
//
//
//        }
//
//        return answer;
//    }
//}
