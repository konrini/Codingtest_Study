import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1927_최소힙 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		//연산 개수, 1~100000
		int N = sc.nextInt();
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		//연산 정보, 0~2^31
		//자연수: 추가, 0: 가장 작은 값 출력하고 제거
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			
			if(x==0) {
				if(q.isEmpty())
					sb.append("0").append("\n");
				else
					sb.append(q.poll()).append("\n");
			}else {
				q.offer(x);
			}
		}
		System.out.println(sb);
		
	}

}
