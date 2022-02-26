import java.util.Scanner;

public class BOJ_2578_빙고 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		} // end board input

		int bcnt = 0; // bingo count

		// 25번 반복
		for (int ans = 1; ans <= 25; ans++) {
			int a = sc.nextInt();
			// change
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == a) {
						board[i][j] = 0; // 불린 수 0으로 바꾸기
					}
				}
			} // end change
			
			// 행/열 check
			for (int i = 0; i < 5; i++) {
					int r = 0;
					int c = 0;
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == 0) r++;
					if (board[j][i] == 0) c++;
					if (r == 5) bcnt++;
					if (c == 5) bcnt++;
				}
			}

			// 대각선 check
			int l =0;
			int r =0;
			for (int i = 0; i < 5; i++) {
				
				if(board[i][i]==0)   r++;
				if(board[i][4-i]==0) l++;
				if(r==5) bcnt++;
				if(l==5) bcnt++;
			}
			// count check
			if(bcnt>2) {
				System.out.println(ans);
				break;
			}
			bcnt =0;   //bingo count 초기화
		} // end repeat

	}

}
