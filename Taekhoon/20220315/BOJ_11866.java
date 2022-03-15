package boj.class2;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11866 { // 요세푸스 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		
		// 사람들의 상태를 나타내는 배열0은 살아있는 사람, -1은 죽임을 당한 사람
		int[] arr = new int[N]; 
		
		ArrayList<Integer> ans = new ArrayList<>();
		

		int killNum = 0; // 죽인 총 사람 수
		int idx = 0; // 죽일지 말지 고민하고 있는 사람의 인덱스
		
		// 총 죽인 사람의 수가 N이 될때까지 반복
		while (killNum < N) {
			int checkNum = 0; // 지금까지 체크한 사람의 수 즉, N-1번째 체크까진 봐줌, 그 다음 죽임
			
			// K-1번까지는 봐줌
			while(checkNum < K-1) {
				
				// 현재 죽일지 말지 고민 하는 사람이 살아있다면 체크한 사람 +1해주고 idx도 옮겨줌
				if(arr[idx] == 0) {
					idx = (idx+1 == N) ? 0 : idx+1;
					checkNum++;
				
					
				// 현재 죽일지 말지 고민하는 사람이 시체라면 idx만 옮겨줌(다음 사람으로 넘어감)
				}else {
					idx = (idx+1 == N) ? 0 : idx+1;
				}
			} // K-1번째 사람까진 살려줌
			
			// 다음 살아있는 사람은 무조건 죽음
			while(arr[idx] != 0) { // 살아있지 않으면 idx만 옮겨주고 
				idx = (idx+1 == N) ? 0 : idx+1;
			}
			// 살아있는 사람을 찾으면 죽이고(값을 -1로 바꾸고) 죽인 사람 총 수 올려줌
			arr[idx] = -1;
			killNum++;
			ans.add(idx+1); // n번째 인덱스의 사람은 n+1번째 사람
		} // 죽이기 종료
		
		
		
		// 출력 형식에 맞게 출력            toString() 재정의 어케함?
		StringBuilder sb =new StringBuilder();
		sb.append("<");
		for(int i=0; i < ans.size()-1;i++) {
			sb.append(ans.get(i) + ", ");
		}
		sb.append(ans.get(ans.size()-1));
		sb.append(">");
		System.out.println(sb.toString());
	}

}
