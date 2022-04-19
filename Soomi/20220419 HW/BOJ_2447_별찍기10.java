import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2447_별찍기10 {

	public static int N;
	public static String [][]star;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		//3의 거듭제곱
		N = sc.nextInt();
		star = new String[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(star[i], " ");
		}
		
		MakeSpace(N,0,0);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(star[i][j]);
			}sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static void MakeSpace(int n, int start, int end) {
		
		if(n==1) {
			star[start][end] = "*";
			return;
		}
		
		int size = n/3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1)
					continue;
				else
					MakeSpace(size, size*i+start, size*j+end);

			}
		}
		
	}

}
