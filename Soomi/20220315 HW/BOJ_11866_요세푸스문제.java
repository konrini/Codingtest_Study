import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866_요세푸스문제 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		//N명의 사람
		int N = sc.nextInt();
		//순서대로 K번째 사람 제거
		int K = sc.nextInt();
		
		
		Queue<Integer> josep = new LinkedList<Integer>();
		
		for (int man = 1; man <= N; man++) {
			josep.add(man);
		}
		
		//queue 비면 끝
		while(josep.size()!=1) {
			//k번째 죽이기
			for (int man = 0; man < K-1; man++) {
				josep.add(josep.poll());
			}
			int ans = josep.poll();
			sb.append(ans).append(", ");
		}
		sb.append(josep.poll()).append(">");
		System.out.println(sb);
	}

}
