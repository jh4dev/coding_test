package practice.lvl2;

import java.util.Arrays;

/**
 * 2 x 2 블록이 삭제되는 게임
 * 중첩 가능
 * 
 * */
public class KakaoBlockGame {

	static int answer = 0;
	
	public static void main(String[] args) {

		int m = 8;
		int n = 5;
		String[] board = {
				  "HGNHU"
				, "CRSHV"
				, "UKHVL"
				, "MJHQB"
				, "GSHOT"
				, "MQMJJ"
				, "AGJKK"
				, "QULKK"
				};
		
		
		System.out.println(solution(m, n, board));
	}
	
	public static int solution(int m, int n, String[] board) {
        
        String[][] game = new String[m][n];
        
        for(int i = 0; i < m; i++) {
        	game[i] = board[i].split("");
        }

        while(checkBoard(game)) {
        	refreshBoard(game);
        }
        
        return answer;
    }
	
	public static boolean checkBoard(String[][] game) {
		
		boolean checkResult = false;
		int sameCnt;
		String basePoint;
		
		for(int i = game.length - 2; i >= 0; i--) {
    		
    		for(int j = game[0].length - 1; j >= 1; j--) {
    			sameCnt = 0;
    			
    			if(!game[i][j].equals("#")) {
    				
    				basePoint = game[i][j].replaceAll("#", "");
    				
    				if(!(basePoint.charAt(0) >= 65 && basePoint.charAt(0) <= 90)) {
    					continue;
    				}
    				//좌
    				if(basePoint.equals(game[i][j-1].replaceAll("#", ""))) {
    					sameCnt++;
    				}
    				
    				//하
    				if(basePoint.equals(game[i+1][j].replaceAll("#", ""))) {
    					sameCnt++;
    				}
    				
    				//좌하
    				if(basePoint.equals(game[i+1][j-1].replaceAll("#", ""))) {
    					sameCnt++;
    				}
    				
    				if(sameCnt == 3) {
    					game[i][j] 		+= "#";
    					game[i][j-1] 	+= "#";
    					game[i+1][j] 	+= "#";
    					game[i+1][j-1] 	+= "#";
    					
    					checkResult = true;
    				}
    			}
			}
		}
		return checkResult;
	}
	
	
	public static String[][] refreshBoard(String[][] game) {
		
		int[] block;
		for(int i = game.length - 1; i >= 0; i--) {
    		for(int j = game[i].length - 1; j >= 0; j--) {
    			
    			if(game[i][j].indexOf("#") < 0) {
    				continue;
    			} else {
    				//위쪽으로 가장 가까운 X 를 포함하지 않은 값으로 치환, 해당 값은 X 로 치환
    				if(game[i][j].indexOf("#") > 0) {
    					game[i][j] = "#";
        				answer++;
    				}
    				
    				block = findExistBlock(game, i, j);
    				if(block[0] > -1 && block[1] > -1) {
    					game[i][j] = game[block[0]][block[1]];
    					game[block[0]][block[1]] = "#";
    					
    				printBoard(game);
    				}
    			}
    		}
		}
		return game;
	}
	
	
	public static int[] findExistBlock(String[][] game, int row, int col) {
		int[] block = {-1, -1};
		
		for(int i = row-1; i >= 0; i--) {
			if(game[i][col].indexOf("#") < 0) {
				block[0] = i;
				block[1] = col;
                break;
			}
		}
		return block;
	}
	
	public static void printBoard(String[][] game) {
		for(int k = 0; k < game.length; k++) {
        	System.out.println(Arrays.toString(game[k]));
        }
		System.out.println("------------------------");
	}
}
