import java.util.Scanner;

public class BOJ_1012_유기농배추 {

	public static int map[][], ans, M, N;
	public static boolean check[][];
	//상하좌우
	public static int drc[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//test case
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			//가로길이, 1~50
			M = sc.nextInt();
			//세로길이, 1~50
			N = sc.nextInt();
			//배추 몇 개?, 1~2500
			int K = sc.nextInt();
			
			map   = new int[M][N];
			check = new boolean[M][N];
			
			//최소 지렁이 구하기, 배추 개수로 초기화
			ans = 0;			
			
			//1:배추
			for(int i=0; i<K; i++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==1 && !check[i][j]) {
						check[i][j] = true;
						ans++;
						find(i,j);
					}
				}
			}

			sb.append(ans).append("\n");
		}//test case
		System.out.println(sb);
	}//main
	public static void find(int r, int c) {
		
		for(int i=0; i<4; i++) {
			int nr = r+drc[i][0];
			int nc = c+drc[i][1];
			
			if(nr<0 || nc<0 || nr>=M || nc>=N)
				continue;
			if(check[nr][nc])
				continue;
			if(map[nr][nc]!=1)
				continue;
			
			check[nr][nc] = true;
			find(nr, nc);
			
		}
	}

}
