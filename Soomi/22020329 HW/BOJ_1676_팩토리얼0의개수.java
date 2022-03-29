import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1676_팩토리얼0의개수 {

	public static void main(String[] args) {
		//N! 뒤에서부터 0이 아닌 숫자가 나올때까지 0의 개수 구하기
		Scanner sc = new Scanner(System.in);
		
		//0~500, 재귀함수 쓰면 큰 숫자 X
		int N = sc.nextInt();
		
		//1~N 까지 곱해서 10 만들때마다 ans++
		int ans =0;
		
		//2, 5 나올때마다 10 한 개
		int two =0;
		int five =0;
		for(int i=2;i<=N;i++) {
			int num =i;
			while(num%2==0) {
				two++;
				num/=2;
			}
			while(num%5==0) {
				five++;
				num/=5;
			}
		}
		
		ans = Math.min(two, five);
		
		System.out.println(ans);
	}

}
