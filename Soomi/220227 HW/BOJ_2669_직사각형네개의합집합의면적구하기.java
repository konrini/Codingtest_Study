import java.util.Scanner;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] board = new int[100][100];  //보드 생성
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				board[i][j] = 0;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			int leftx = sc.nextInt();
			int lefty = sc.nextInt();
			int rightx = sc.nextInt();
			int righty = sc.nextInt();
			
			for (int j = leftx; j < rightx; j++) {
				for (int j2 = lefty; j2 < righty; j2++) {
					board[j][j2] = 1;
				}
			}
			
		}
		int cnt =0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(board[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
