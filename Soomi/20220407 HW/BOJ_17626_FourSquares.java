import java.util.Scanner;

public class BOJ_17626_FourSquares {

	public static int n, num[];
	public static void main(String[] args) {

		//최소 개수의 제곱수 합으로 표현, 4개 이하 개수
		Scanner sc = new Scanner(System.in);
		//1~50000, 230^2 = 52900
		n = sc.nextInt();
		
		num = new int[n+1];
		num[0] = 0;
				
		findSquare(n);
		System.out.println(num[n]);
		
	}//end main
	
	public static void findSquare(int idx) {
		//큰 수부터하면 안됨... 더 적은 개수 있을 수 있음
		
		for(int i=1; i<=idx; i++) {
			num[i] = Integer.MAX_VALUE;
			int sqrt = (int)Math.sqrt(i);
			while(sqrt>0) {
				int cnt = num[i-sqrt*sqrt] +1;
				num[i] = Math.min(num[i], cnt);
				sqrt--;
			}
		}
	}

}
