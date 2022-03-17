package boj.class2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> s = new Stack<>();
		ArrayList<String> ans = new ArrayList<>();
		int[] toFind = new int[n+1];
		
		// 찾아야하는 수 차례대로 입력받기
		for(int i =1;i <=n;i++) {
			toFind[i] = sc.nextInt();
		}
		
		
		// 오름차순으로 스택에 넣기
		// 넣다가 원하는 숫자 나오면 빼고 ans에 -추가
		
		int m = 1; // 찾아야하는 숫자의 인덱스
		for(int i =1;i<n;i++) {
			s.push(i);
			ans.add("+");
			
			while(!s.isEmpty() && s.peek() == toFind[m]) {
				s.pop();
				ans.add("-");
			}
		}
		
		// 로직 종료 후 스택이 비어있어야 성공
		if(s.isEmpty()) {
			for(String str : ans) {
				System.out.println(str);
			}
		} else {
			System.out.println("NO");
		}

	}
}
