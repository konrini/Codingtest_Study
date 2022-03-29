import java.util.Scanner;

public class BOJ_18111_마인크래프트 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();  //세로
		int M = sc.nextInt();  //가로
		int B = sc.nextInt();  //인벤토리 블록 개수
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int h = sc.nextInt();
				map[i][j] = h;
				
				if(h<min) {
					min = h;
				}else if(h>max) {
					max = h;
				}
			}
		}//end input map height
		
		int time = Integer.MAX_VALUE;
		int ans = 0;  //높이
		
		for (int i = min; i <= max; i++) {
			
			int t = 0;
			int b = B;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[j][k]>i) {
						t+= (map[j][k]-i) * 2;
						b+= map[j][k]-i;
					}else if(map[j][k]<i) {
						t+= i-map[j][k];
						b-= i-map[j][k];
					}
				}
			}
			
			if(time>=t && b>=0) {
				time = t;
				ans = i;
			}
			
		}
		System.out.println(time + " " + ans);
	}

}
