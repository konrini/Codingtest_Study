package boj.class3;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1541_잃어버린괄호 {
	static int idx;
	static char[] charArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		idx = 0; // 현재까지 진행된 인덱스 번호
		charArr = sc.next().toCharArray(); // 식을 char배열로 받음
		int plus = 0; // 더할 숫자
		int minus = 0; // 뺄 숫자
		// 초기값
		plus = makeNum(); // 시작 숫자
		boolean flag = true; // 직전 연산자가 +였으면 true, -였으면 false
		
		// idx가 끝까지 진행될 동안 while문 수행
		while(idx < charArr.length) {
			// 이번 연산자가 +인 경우
			if(charArr[idx] == '+') {
				++idx; // 일단 idx 올려줌 
				
				// 직전 연산자가 +였다면 더할 수 밖에 없으므로 plus
				if(flag == true) {
					plus += makeNum();
				// 직전 연산자가 -였다면 괄호로 묶인 상태로 보고 빼는 수(minus)를 증가시켜줌
				} else {
					minus += makeNum();
				}
				
			// 이번 연산자가 -인 경우엔 무조건 뺄 수 있으므로 빼는 수(minus)를 증가	
			} else {
				flag = false;
				++idx;
				minus += makeNum();
			}
		}
		System.out.println(plus - minus);
	} // main

	// char로 받은 숫자를 int로 변환해주는 함수
	// 여기서 idx는 static으로 했으므로 parameter를 따로 안받아도됨
	public static int makeNum() {
		int num = 0; // 변환된 값
		
		// 현재 idx부터 연산자가 나오기 직전까지의 숫자를 char배열에 저장
		ArrayList<Character> charNum = new ArrayList<>();
		while(idx < charArr.length && '0' <= charArr[idx] && charArr[idx] <= '9') {
			charNum.add(charArr[idx++]);
		}
		
		// 만들어진 char배열을 돌면서 자릿수에 맞춰서 int형으로 변환
		for(int i = 0; i < charNum.size(); i++) {
			num += (charNum.get(i) -'0') * (int) Math.pow(10, charNum.size()-1-i);
		}
		
		// 변환된 숫자를 return
		return num;
	}
}
