package boj.class2;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();

		int temp = 0; // 두 수를 뺀 결과를 저장하는 변수
		int maxCnt = 0; // 최대개수 저장하는 변수

		int second = 1; // 두번째 수
		
		ArrayList<Integer> resultList = new ArrayList<>();

		// 결과값들을 저장할 리스트
		ArrayList<Integer> list = new ArrayList<>();
		
		// result값이 음수일 때까지 작업 반복
		while (second <= start) {
			if(list.isEmpty()) { // 빈 리스트가 들어오면 첫번째, 두번째값 추가
				list.add(start);
				list.add(second); // 두번째 수는 한번 쓰고 1씩 증가
			}

			// 빼야하는 두 수는 리스트의 (마지막인덱스 -2)와 (마지막 인덱스-1)
			temp = list.get(list.size() - 2) - list.get(list.size() - 1);
			
			// 결과값이 양수면 리스트에 저장
			if (temp >= 0) {
				list.add(temp);
				// 저장 후 숫자의 개수가 최대라면 
				if(list.size() > maxCnt) {
					// 최대값 갱신
					maxCnt = list.size();

					// 새로운 리스트를 만들어서 그 값들을 resultList로 넘겨줌(deep copy)
					ArrayList<Integer> tempList = new ArrayList<>();
					for(int i = 0; i < maxCnt;i++) {
						tempList.add(list.get(i));
					}
					resultList = tempList;
					
					/* 이부분이 실행이 안되는 이유 ? ㅠ
					shallow copy, deep copy
					주소를 복사, 값만 복사
					resultList = list;
					*/
					
					
				}
			
			} else {// result값이 음수면 
				second++; // 두번째로 들어갈 수 1증가시키고, 
				list.clear(); // 리스트 비우기
			}
				
		} // while문 종료
		System.out.println(maxCnt);
		for(int i = 0; i < maxCnt; i++) {
			System.out.print(resultList.get(i) + " ");
		}
	}
}
