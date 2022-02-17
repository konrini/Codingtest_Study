package boj.class2;

import java.util.Scanner;

public class Boj_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N번째 찾는 영화의 번호
		int N = sc.nextInt();

		// 시리즈 번호
		int num = 666;
		// 현재 시리즈 번호에 해당하는 영화의 순서? 
		int cnt = 1;
        
        // 현재 시리즈 번호에 해당하는 영화의 순서가 입력받은 영화의 순서와 같을 때까지 while문 반복
		while(true) {
			if(cnt == N) {
				break; // 같으면 while문 나옴
			}
            // 666을 포함하는 번호를 찾기위해 1씩 증가시킴
			num++;
            // 정수 num을 문자열로 바꾸고 그 문자열이 666을 포함 시키면 cnt 1증가
			if(Integer.toString(num).contains("666")) cnt++;
		}
        //cnt==N일때의 시리즈 번호
		System.out.println(num);
	}
}
