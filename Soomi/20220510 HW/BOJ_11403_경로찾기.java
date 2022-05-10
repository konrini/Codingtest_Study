import java.util.Scanner;

public class BOJ_11403_경로찾기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//정점 개수
		int N = sc.nextInt();
		
		// 1:간선 존재, 0:간선 없음
		int Graph[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Graph[i][j] = sc.nextInt();
			}
		}//input
		
		//int ans[][] = new int[N][N];
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(Graph[i][k]==1) {
						if(Graph[k][j]==1) {
							Graph[i][j] = 1;
						}
					}
				}
			}
		}//floyd
		
		// print
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(Graph[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
