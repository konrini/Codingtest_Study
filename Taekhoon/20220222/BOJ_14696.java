package boj.class2;

import java.util.Scanner;

public class BOJ_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 라운드 수

		for (int R = 1; R <= N; R++) {
			int a = sc.nextInt(); // A의 딱지에 있는 문양의 수
			int[] Acard = new int[5]; // A의 딱지에 있는 문양들의 개수를 저장하는 배열(크기가 5는 인덱스때문에)

			// 입력받은 문양에 따라 개수 세기
			for (int i = 0; i < a; i++) {
				Acard[sc.nextInt()]++;
			}

			int b = sc.nextInt(); // B의 딱지에 있는 문양의 수
			int[] Bcard = new int[5]; // B의 딱지에 있는 문양들의 개수를 저장하는 배열
			for (int i = 0; i < b; i++) {
				Bcard[sc.nextInt()]++;
			}
			
			
			// 4번 인덱스부터 비교, 같으면 3번인덱스 -> 2번인덱스 순으로 비교
			for(int i = 4; i>=1; i--) {
				if(Acard[i] > Bcard[i]) {
					System.out.println("A");
					break;
				} else if (Acard[i] < Bcard[i]) {
					System.out.println("B");
					break;
				} else {
					if(i == 1) { // 1번 인덱스까지 똑같으면 비김!
						System.out.println("D");
					}
					continue;
				}
			}
		} // 모든 라운드 종료
	} // main 종료
}
