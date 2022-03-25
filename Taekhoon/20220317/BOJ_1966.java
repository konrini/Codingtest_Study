package boj.class2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Queue<String> q = new LinkedList<>();
			ArrayList<Integer> list = new ArrayList<>();
			int N = sc.nextInt();

			// 궁금한 문서
			String toFind = sc.next();

			// 각 문서의 이름은 입력받았을때의 인덱스
			// 리스트에 큐의 순서에 맞게 중요도를 저장
			for (int i = 0; i < N; i++) {
				q.add(i + "");
				list.add(sc.nextInt());
			}

			// 지금 뽑힌 녀석이 몇 번째로 뽑힌 녀석인지(순서)
			int order = 1;

			while (order <= N) {
				
				// 큐에 자신보다 중요도 높은게 있는지 확인
				boolean flag = false; // 중요도 높은게 있으면 true, 없으면 false
				for (int i = 0; i < q.size(); i++) {
					if( list.get(0) < list.get(i)) { // 중요도 높은게 있으면
						flag = true;
						q.add(q.poll());
						int temp = list.get(0);
						list.remove(0);
						list.add(temp);
						break;
					}
				}
				// 중요도 높은게 없으면 큐에서 제거
				if(!flag) {
					if(q.peek().equals(toFind)) { // 제거하는 녀석이 찾는 녀석이면 출력
						System.out.println(order);
						break;
					} else {
						q.poll();
						list.remove(0);
						order++;
					}
				}
			}
		}

	}

	
}
