import java.util.Scanner;

public class Baekjoon_1436 {

	public static void main(String[] args) {

		//6이 적어도 3개 이상 연속으로 들어가는 숫자
		//N번째로 작은 숫자 찾기
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int devil = 666;
		int idx = 2;
		
		//i번째 수 찾기
		while(idx<=N) {
			devil++;
			//666보다 큰 수 중에 666포함한 수 찾기
			if(String.valueOf(devil).contains("666")) {
				idx++;
			}
		}
		System.out.println(devil);
	}

}
