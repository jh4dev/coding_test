package lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileNameSorting {

    public static void main(String[] args) {


//        String files[] = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    	String files[] = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        
        System.out.println(Arrays.toString(solution(files)));
    }
    
    public static String[] solution(String[] files) {
    	
    	//String array to String List
    	//array to list
//    	List<String> fileList = new ArrayList<String>(Arrays.asList(files));
    	List<MyFile> fileList = new ArrayList<>();
    	for(int i = 0; i < files.length; i++) {
    		fileList.add(new MyFile(files[i], i));
    	}
    	
//    	fileList.forEach(t -> System.out.println(t.ognName));
    	
    	Comparator<MyFile> comparator = new MyFileComparator();
    	Collections.sort(fileList, comparator);
    	
    	List<String> answerList = new ArrayList<>();
    	for(MyFile myFile : fileList) {
    		answerList.add(myFile.ognName);
    	}
    	
    	return answerList.toArray(new String[answerList.size()]);
    }
    

    static class MyFile{

        String head;
        int number;
        String tail;
        String ognName;

        int defaultOrder;

        private int firstDigitIdx;
        private int lastDigitIdx;

        public MyFile(String file, int order) {

            defaultOrder = order;
            ognName = file;
            lastDigitIdx = file.length()-1;
            
            boolean isFirst = true;
            for (int i = 0; i < file.length(); i++) {
                if (isFirst && Character.isDigit(file.charAt(i))) {
                    firstDigitIdx = i;
                    isFirst = false;
                    continue;
                }

                if(!isFirst && !Character.isDigit(file.charAt(i))) {
                    lastDigitIdx = i - 1;
                    break;
                }
            }

            this.head = file.substring(0, firstDigitIdx).toUpperCase();
            this.number = Integer.parseInt(file.substring(firstDigitIdx, lastDigitIdx + 1));
            
            //tail 공백 체크
            if(lastDigitIdx + 1 == file.length()) {
            	this.tail = "";
            } else {
            	this.tail = file.substring(lastDigitIdx + 1);
            }

        }

    }
    
    static class MyFileComparator implements Comparator<MyFile> {
        @Override
        public int compare(MyFile o1, MyFile o2) {
        	// return -1 => 오름차순
            // 1. HEAD : 사전 순
            if(o1.head.compareTo(o2.head) != 0) {
            	return o1.head.compareTo(o2.head);
            }
            
            // 2. NUMBER : 크기 오름차순
            if(o1.number != o2.number) {
            	return Integer.compare(o1.number, o2.number);
            }
            
            // 3. 원래 입력순서 유지
            return o1.defaultOrder - o2.defaultOrder;
       
        }

    }
}
