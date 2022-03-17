package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2941 { // 크로아티아 알파벳
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int ans = 0; // 알파벳의 개수

		// 하나로 인식시켜줘야할 알파벳
		String[] target = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		// target문자열이 str에 포함되어 있으면 가장 첫번째 문자열을 구분 문자열로 바꾼 후 1씩 카운트
		for (int i = 0; i < target.length; i++) {
			while (str.contains(target[i])) {
				str = str.replaceFirst(target[i], "/");
				ans++;
			}
		}
		// 구분 문자열을 기준으로 문자열을 자른 뒤
		// 잘린 문자열이 각각 몇 개의 알파벳으로 이루어져있는지 확인후 ans에 더하기
		String[] str2 = str.split("/");
		for (int j = 0; j < str2.length; j++) {
			ans += str2[j].length();
		}
		;
		System.out.println(ans);
	}
}
