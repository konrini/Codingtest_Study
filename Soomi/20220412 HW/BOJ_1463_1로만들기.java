import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	public static int ans;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//1~10^6
		int N = sc.nextInt();
		ans = Integer.MAX_VALUE;
		
		Find(N,0);
		
		System.out.println(ans);
	}//main
	public static void Find(int n, int cnt) {
		if(n==1) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(cnt >= ans) return;
		
		if(n%3==0) Find(n/3, cnt+1);
		
		if(n%2==0) Find(n/2, cnt+1);
		
		//10이면 2로 나뉘지만 답: 1 먼저 뺀 뒤 3으로 나누기
		Find(n-1, cnt+1);
	}
}
