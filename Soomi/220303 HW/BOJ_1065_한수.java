import java.util.Scanner;

public class BOJ_1065_한수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		//1부터 N까지 중 한수 개수
		int cnt =N;
		
		//100까지는 모두 한수
		if(N>=100) {
			
			for (int i = 100; i <=N ; i++) {
				//여러분을 위한 변수명ㅎㅎ
				int one = i%10;
				int ten = (i/10) %10;
				int hundred = i/100;
				
				//한수 아니면 cnt--
				if((ten-one)!=(hundred-ten)) {
					cnt--;
				}
			}
			
		}
		
		System.out.println(cnt);
		
	}

}
