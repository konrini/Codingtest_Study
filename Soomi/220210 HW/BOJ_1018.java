import java.util.Scanner;

public class Baekjoon_1018 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 보드 입력받기
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String color = sc.next();
			
			for (int j = 0; j < M; j++) {
				String c = color.charAt(j)+"";
				if (c.equals("B")) {
					board[i][j] = 0;  //black을 0
				} else {
					board[i][j] = 1;  //white는 1로 치환
				}
			}
		}
		
		//black으로 시작하는 체스판 만들기
		int[][] bc = new int [8][8];
		boolean a= false;
		for(int i=0;i<8;i++) {
			a=!a;
			for(int j=0;j<8;j++) {
				if(a) {
					bc[i][j]=1;
				}else{
					bc[i][j]=0;
				}
				a = !a;
			}
		}
		
		//white로 시작하는 체스판 만들기
		int[][] wc = new int [8][8];
		for(int i=0;i<8;i++) {
			a=!a;
			for(int j=0;j<8;j++) {
				if(a) {
					wc[i][j]=0;
				}else{
					wc[i][j]=1;
				}
				a = !a;
			}
		}
		
		int cnt =64;  //최소값 저장할 변수
		//보드에서 M-7, N-7만큼 반복
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				
				int bcnt =0;  //검은색 보드랑 비교해서 바꾼만큼 더해줄 변수 초기화
				int wcnt =0;  //하얀색 보드랑 비교해서 바꾼만큼 더해줄 변수 초기화
				
				//8*8 잘라내기
				for(int k=i;k<i+8;k++) {
					for(int l=j;l<j+8;l++) {
						//black 보드와 비교
						if(board[k][l]!=bc[k-i][l-j]) {
							bcnt++;
						}
						if(board[k][l]!=wc[k-i][l-j]) {
							wcnt++;
						}
					}
				}//8*8잘라내는 for문 end
				
				if(cnt>Math.min(bcnt, wcnt)) {
					cnt =Math.min(bcnt, wcnt);
				}
				
			}
		}
		
		System.out.println(cnt);
	}
}