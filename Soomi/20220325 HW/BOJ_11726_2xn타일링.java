import java.util.Scanner;

public class BOJ_11726_2xn타일링 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//2XN 크기 직사각형 채우기, n은 1000까지
		int n = sc.nextInt();
		
		//n=1일때 1, 2일때 2, 3일때 3, 4일때 5, 5일때 8가지
		//n번째 경우의 수는 n-1번째 경우의 수 + n-2번째 경우의 수
		
		double[] tile = new double[1000];
		
		tile[0] = 1; tile[1] = 2;
		
		for(int i=2; i<n;i++) {
			tile[i] = (tile[i-1]+tile[i-2]) %10007;
		}
		
		//경우의 수를 10007로 나눠서 출력
		System.out.println((int)tile[n-1]);
	}

}
