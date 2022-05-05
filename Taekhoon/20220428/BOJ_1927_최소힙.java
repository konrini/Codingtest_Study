package boj.class3;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1927_최소힙 {
	public static void main(String[] args) {
		ArrayList<Integer> minHeap = new ArrayList<>();
		minHeap.add(987654321); // just to ignore index 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N;i++) {
			int x = sc.nextInt();
			if( x > 0) {
				insert(minHeap, x);
			} else if(x == 0) {
				System.out.println(delete(minHeap));
			}
		}
		
	}

	public static void insert(ArrayList<Integer> heap, int num) {
		heap.add(num);
		int idx = heap.size() - 1;
		while (idx > 1 && heap.get(idx / 2) > heap.get(idx)) {
			// 부모노드와 자식노드 교체!
			int temp = heap.get(idx); // 자식노드
			heap.set(idx, heap.get(idx / 2));
			heap.set(idx / 2, temp);
			idx /= 2;
		}
	}

	public static int delete(ArrayList<Integer> heap) {
		if(heap.size() == 1) { // 힙이 비어있으면 0 리턴
			return 0;
		} else {
			int result = heap.get(1); // 루트노드 result에 저장
			heap.set(1, heap.get(heap.size() - 1)); // 가장 마지막 노드를 루트노드로 이동
			heap.remove(heap.size() - 1); // 마지막 노드 제거
			int idx = 1; // 시작 인덱스
			// 왼쪽 자식이 heap의 크기보다 작을때까지만 반복
			while (idx * 2 < heap.size()) {
				int min = heap.get(idx * 2); // 일단 min값으로 왼쪽자식의 값 입력
				int minIdx = idx * 2; // min값의 idx
				if(idx * 2 + 1 < heap.size() && min > heap.get(idx*2+1)) { // 오른쪽 자식이 존재하고 min값보다 작으면 
					min = heap.get(idx*2+1); // min값과 
					minIdx = idx * 2 + 1; // 그때의 idx 갱신
				}
				// 부모노드의 값이 작으면 다 필요없고(최소힙의 조건을 만족하므로) while break;
				if(min > heap.get(idx)) {
					break;
				}
				// 그렇지 않은경우 부모노드와 min값을 저장하고 있는 자식노드 swap
				int temp = heap.get(idx);
				heap.set(idx, heap.get(minIdx));
				heap.set(minIdx, temp);
				idx = minIdx;
			}
			// 루트노드의 값 리턴
			return result;
		}
		
	}
}
