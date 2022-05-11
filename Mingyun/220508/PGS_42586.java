package PGS_220504;

import java.util.*;

public class PGS_42586_기능개발 {
	class Solution {
		public int[] solution(int[] progresses, int[] speeds) {

			int startIdx = 0; // 시작 인덱스
			int size = progresses.length; // 작업들의 크기
			ArrayList<Integer> ansList = new ArrayList<>(); // ArrayList에 담아두기~

			while (startIdx != size) {
				// 한 번 루프 돌기
				for (int i = 0; i < size; i++)
					progresses[i] += speeds[i];
				// 현재 보고있는 인덱스(0)번쨰 부터 시작한게 100 이상이 되는 순간
				if (progresses[startIdx] >= 100) {
					// 배포 시작
					// 개수 count 1
					int cnt = 1;
					// startIdx에 1 더한게 가 자료의 개수보다 작을 동안..
					while (++startIdx < size) {
						// 근데 startIdx가 범위 벗어나? 응 끝
						if (startIdx == size)
							break;
						// 1 증가시킨 startIdx번째 자료가 100보다 커? 응 너도 배포
						if (progresses[startIdx] >= 100)
							cnt++;
						else
							break;
					} // end while : 동시에 배포되는거 찾기
					ansList.add(cnt);
				} // end if : 100이상거 찾을 때
			} // end while : 전체 끝~
				// Arraylist -> 배열!
			int[] answer = new int[ansList.size()];
			for (int i = 0; i < ansList.size(); i++) {
				answer[i] = ansList.get(i);
			}
			return answer;
		}
	}

}
