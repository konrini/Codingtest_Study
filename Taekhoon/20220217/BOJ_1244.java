package boj.class2;

import java.util.Scanner;

public class BOJ_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bulbCnt = sc.nextInt(); // 전구의 개수

		// 인덱스 사용의 편의성을 위해서 1번부터 전구의 상태가 들어가도록 하여 마지막 인덱스가 전구의 개수가 되도록한다.
		int[] status = new int[bulbCnt + 1];
		// 1번부터 전구의 상태를 입력 받음
		for (int i = 1; i < status.length; i++) {
			status[i] = sc.nextInt();
		}

		int studentNum = sc.nextInt(); // 학생 수

		// 학생 수만큼 반복하면서 switch문
		for (int i = 0; i < studentNum; i++) {
			
			switch (sc.nextInt()) {
			
			// 남학생
			case 1:
				status = boyAct(sc.nextInt(), status);
				break;
				
			// 여학생
			case 2:
				status = girlAct(sc.nextInt(), status);
				break;
			}
		} // 전구 상태 바꾸기 종료
		
		// 조건에 맞게 출력
		for(int i = 1; i < status.length;i++ ) {
			System.out.print(status[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}

	} // main 함수 종료

	// 남학생 카드의 숫자, 스위치 배열을 받고 스위치 상태 리턴해줌
	public static int[] boyAct(int cardNum, int[] bulbArr) {
		// 카드의 숫자의 배수에 해당하는 인덱스의 전구상태를 바꿈
		for(int i = 1; i < bulbArr.length; i++) {
			if (i % cardNum == 0) {
				bulbArr[i] = changeBulb(bulbArr[i]);
			}
		}
		return bulbArr;
	}

	// 여학생 카드의 숫자, 스위치 배열을 받고 스위치 상태 리턴해줌
	public static int[] girlAct(int cardNum, int[] bulbArr) {
		// 여학생의 카드 숫자를 기준으로 대칭을 검사할 범위(짧은쪽까지만 검사하기 위함) 
		int range = ((bulbArr.length-1) - cardNum < (cardNum - 1)) ? (bulbArr.length-1) - cardNum : cardNum -1;
		
		// 우선 대칭의 중심은 무조건 바꿈
		// 아래에서 한 번에 처리할려니까 대칭의 중심이 2번 바껴서 따로 뺐음
		bulbArr[cardNum] = changeBulb(bulbArr[cardNum]);
		// 한 칸씩 양옆으로 가면서 숫자가 같으면 상태를 바꿔주고 숫자가 다르면 break
		for(int i = 1; i <= range; i++) {
			if(bulbArr[cardNum - i] == bulbArr[cardNum + i]) {
				bulbArr[cardNum - i] = changeBulb(bulbArr[cardNum - i]);
				bulbArr[cardNum + i] = changeBulb(bulbArr[cardNum + i]);
			}else {
				break;
			}
		}
		return bulbArr;
	}

	// 전구 상태를 바꾸는 함수
	public static int changeBulb(int num) {
		num = 1 - num;
		return num;
	}

}
