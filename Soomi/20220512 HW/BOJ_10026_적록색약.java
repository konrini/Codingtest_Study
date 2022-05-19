import java.util.Scanner;

public class BOJ_10026_적록색약 {

	public static int N, map[][];
	public static int drc[][]= {{-1,0},{0,1},{1,0},{0,-1}};  //상우하좌
	public static boolean check[][];
	public static void main(String[] args) {
		// 상하좌우로 같은 색이면 같은 영역, 영역 개수 출력 / (RG),B 영역 출력
		Scanner sc = new Scanner(System.in);
		
		// Map size
		N = sc.nextInt();
		map = new int[N][N];
		check = new boolean[N][N];
		
		// R:1, G:2, B:3
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<N; j++) {
				if(s.charAt(j)=='R')
					map[i][j] = 1;
				else if(s.charAt(j)=='G')
					map[i][j] = 2;
				else
					map[i][j] = 3;
			}
		}// input
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 방문한 적 없으면
				if(!check[i][j]) {
					find(i, j, map[i][j]);
					ans++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// R,G 같은 값으로
				if(map[i][j]==1)
					map[i][j] = 2;
			}
		}
		
		int RGans = 0;
		check = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					find(i, j, map[i][j]);
					RGans++;
				}
			}
		}
		
		System.out.println(ans+" "+RGans);
		
	}// main
	public static void find(int r, int c, int color) {
		// 방문 check
		check[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int dr = r + drc[i][0];
			int dc = c + drc[i][1];
			
			// Map 밖
			if(dr>=N || dc>=N || dr<0 || dc<0)
				continue;
			// 방문한 적 있으면
			if(check[dr][dc])
				continue;
			// 같은 색이면
			if(map[dr][dc]==color)
				find(dr, dc, color);
			
		}
	}

}
