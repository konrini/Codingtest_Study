import java.util.Scanner;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//N개 집, 1~N까지 순서대로
		int N = sc.nextInt();
		
		//R, G, B N번 집 != N-1번 집
		//R, G, B 순서로 비용 입력
		
		int[] Red = new int[N];
		int[] Green = new int[N];
		int[] Blue = new int[N];
		
		for(int i=0;i<N;i++) {
			Red[i] = sc.nextInt();
			Green[i] = sc.nextInt();
			Blue[i] = sc.nextInt();
		}
		
		//i-1번째의 더 작은 것을 더하면 됨
		for(int i=1;i<N;i++) {
			Red[i] += Math.min(Green[i-1], Blue[i-1]);
			Green[i] += Math.min(Red[i-1], Blue[i-1]);
			Blue[i] += Math.min(Green[i-1],Red[i-1]);
		}
		
		System.out.println(Math.min(Red[N-1], Math.min(Green[N-1], Blue[N-1])));
	}//end main


}
