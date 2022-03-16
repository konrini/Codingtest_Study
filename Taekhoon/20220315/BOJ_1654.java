package boj.class2;

/*
 	long mid는 되고 int mid는 안되는 이유
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1654 { // 랜선 자르기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st1.nextToken()); // 기존에 가지고 있던 랜선의 ( 1이상 10,000이하 )
		int N = Integer.parseInt(st1.nextToken()); // 필요한 랜선의 수 ( 1이상 1,000,000이하)
		ArrayList<Integer> cables = new ArrayList<>();

		// 랜선의 길이는 2^31-1보다 작거나 같은 자연수
		for (int i = 0; i < K; i++) {
			cables.add(Integer.parseInt(br.readLine()));
		}

		// N개의 랜선의 길이는 가장 길어도 K의 최댓값보다 작다.
		// K의 최댓값에서 1씩 줄여가면서 N개의 랜선을 만들 수 있는 경우를 찾자

		long start = 1;
		long end = Collections.max(cables);
		
//		int mid는 안됨 ㅠ
		long mid = 0;
		int ans = 0;
		while (start <= end) {
			int cnt = 0;
			mid = ((start + end) / 2);
			for (int i = 0; i < K; i++) {
				cnt += cables.get(i) / mid;
			}
//			System.out.println("===================");
//			System.out.println("start: " + start + " end: " + end);
//			System.out.println("cnt: " + cnt + " mid: " + mid);
//			System.out.println("===================");
			if (cnt >= N) { // 자른 개수가 필요한 개수보다 많거나 같으면 더 큰 길이로 잘라도 됨.
				start = mid + 1;
				ans = (int) Math.max(ans, mid); // 조건을 충족하는 경우 최대의 길이가 정답이되므로
			} else { // 자른 개수가 필요한 개수보다 적으면 더 작은 길이로 잘라야함
				end = mid - 1;
			}
		}
		System.out.println(ans);
	}
}
