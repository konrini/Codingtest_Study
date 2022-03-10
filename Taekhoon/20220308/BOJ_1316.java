package boj.class2;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 단어의 개수
		int cnt = sc.nextInt();
		int ans = cnt; // 그룹단어의 개수

		HashSet<Character> set;
		for (int i = 0; i < cnt; i++) {
			String str = sc.next();
			set = new HashSet<>();

			for (int j = 0; j < str.length(); j++) {
				if( !set.contains(str.charAt(j)) ) { // 문자가 set에 없으면 
					set.add(str.charAt(j)); // set에 해당 문자 추가하고 continue
					continue;
				} else { // 문자가 set에 있으면
					if( j > 0 && str.charAt(j-1) == str.charAt(j)) { // 바로 직전 문자가 현재 문자랑 같으면 continue
						continue;
					} else { // 바로 직전 문자와 다르면 
						ans--;
						break;
					}
				}
			} // 단어 하나 검사 완료
		} // 각 단어들 검사 완료
		
		// 정답출력
		System.out.println(ans);
	}
}
