package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816 { // 숫자 카드 2
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 상근이가 갖고 있는 카드의 개수
		HashMap<Integer, Integer> cards = new HashMap<>();// 상근이가 갖고 있는 카드에 적힌 수의 맵(key는 숫자, value는 그 숫자의 개수)
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		// 입력받기
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st1.nextToken());
			if (cards.containsKey(num)) { // 이미 맵에 입력받은 수가 있는 경우
				int count = cards.get(num);
				cards.put(num, count + 1); // value에 1을 더해준다.
			} else {
				cards.put(num, 1); // 없으면 value를 1로 초기화
			}
		}
		
		// 입력받은 수들을 중복제거후 keyNums에 추가
		ArrayList<Integer> keyNums = new ArrayList<>();
		for (int key : cards.keySet()) { // keySet()은 맵의 key들을 set으로 리턴해주는 함수
			keyNums.add(key);
		}
		
		// 음수값때문에 마음 편히 이진탐색을 쓸 수 없어서...
		// 일단 정렬
		Collections.sort(keyNums);
		int min = keyNums.get(0);
		// 리스트의 모든 수에 가장 작은 값을 빼줌(keyNums의 0번 인덱스의 숫자를 0으로 만들어주기 위함)
		for (int i = 0; i < keyNums.size(); i++) {
			int temp = keyNums.get(i) - min;
			keyNums.set(i, temp);
		}
		
		int M = Integer.parseInt(br.readLine()); // 개수를 구해야할 숫자의 개수
		StringBuilder sb = new StringBuilder();

		// 이진탐색으로 찾을래!
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st2.nextToken()) - min; // 찾아야하는 숫자도 배열에서 빼준 만큼 숫자임!!
			if (bs(keyNums, target)) { // keyNum에 있으면
				// 맵에서 그 숫자를 몇 개 들고 있었는지 확인하고 곱해줘야함
				// 맵에서 key로 찾을땐 다시 빼줬던 만큼 더해준 값으로 찾아야함( 있다가 말로 설명해드림...)
				sb.append(cards.get(target + min) + " ");
			} else { // keyNum에 없으면 0
				sb.append(0 + " ");
			}
			;
		}
		System.out.println(sb.toString());
	} // main 종료
	
	// 이진탐색 -> targetNum 있으면 true, 없으면 false 반환
	public static boolean bs(ArrayList<Integer> list, int targetNum) {
		int start = 0;
		int end = list.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (list.get(mid) == targetNum) {
				return true;
			} else if (list.get(mid) < targetNum) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
}
