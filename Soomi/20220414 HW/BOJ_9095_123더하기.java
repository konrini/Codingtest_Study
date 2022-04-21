import java.util.Scanner;

public class BOJ_9095_123더하기 {
	
	public static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			//<11
			int n = sc.nextInt();
			sb.append(find(n)).append("\n");
		}//test case
		System.out.println(sb);
	}//main
	public static int find(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		return find(n-1) + find(n-2) + find(n-3);
	}
}
