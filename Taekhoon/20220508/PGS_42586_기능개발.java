package programmers;

import java.util.*;

public class PGS_42586_기능개발 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		int[] p = new int[N];
		int[] s = new int[N];
		for(int i = 0 ; i < N;i++) {
			p[i] = sc.nextInt();
		}
		for(int i= 0; i < N;i++) {
			s[i] = sc.nextInt();
		}
//		System.out.println("progresses: " + Arrays.toString(p));
//		System.out.println("speeds: " + Arrays.toString(s));
//		System.out.println();
		System.out.println(Arrays.toString(solution(p,s)));
	}
	
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		int total = 0; // 현재 작업까지 지난 일 수
		
		// 작업순서대로 남은 일수를 q에 add
		for(int i = 0 ; i < progresses.length;i++) {
			progresses[i] = 100 - progresses[i];
			if(progresses[i] % speeds[i] == 0) {
				q.add(progresses[i]/speeds[i]);
			} else {
				q.add(progresses[i] / speeds[i] + 1);
			}
		}
		
		
		while(!q.isEmpty()) {
			int finished = 0; // 이번 배포에 완성된 기능의 개수
			
			++total;
			while(q.peek() != null  && total >= q.peek()) {
				q.poll();
				++finished;
//				System.out.println(111);
			}
			if(finished != 0) {
				result.add(finished);
			}
			
		} // q.isEmpty while종료
		
		
		answer = new int[result.size()];
		for(int i = 0 ; i < result.size();i++) {
			answer[i] = result.get(i);
		}
		
		
		return answer;
	}
}
