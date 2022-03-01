import java.util.Scanner;

public class BOJ_1978_소수찾기 {
	
	public static int cnt;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		cnt =0;

		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			check(a);
		}
		
		System.out.println(cnt);
	}//main end
	
	public static void check(int x) {
		boolean b =true;
		
		//1은 소수 아님
		if(x==1) {
			b = false;
			return;
		}
		
		//2부터 소수 검사
		for (int i = 2; i < x; i++) {
			if(x%i==0) {
				b = false;
			}
		}
		
		//소수면 cnt++
		if(b) cnt++;
	}

}
