package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1244_최대상금 {
	static int[] nums;
	static int[][] changingOrder;
	static ArrayList<int[]> pairs;
	static int cnt;
	static int[] sel;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		// 테스트케이스
		for (int C = 1; C <= T; C++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] str = st.nextToken().toCharArray(); // 숫자판
			cnt = Integer.parseInt(st.nextToken()); // 교환 횟수
			changingOrder = new int[cnt][2];
			pairs = new ArrayList<>();
			// 숫자판의 정보를 정수형으로 arr리스트에 저장
			nums = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				nums[i] = str[i] - '0';
			}

			sel = new int[2];
			comb(nums.length, 0, 0);
//			System.out.println("=============");
//			for (int i = 0; i < pairs.size(); i++) {
//				System.out.println(Arrays.toString(pairs.get(i)));
//			}
//			System.out.println("=============");
			answer = 0;
			permutation(0);
			

			System.out.println("#" + C + " " + answer);
		} // tc

	} // main

	static void comb(int n, int idx, int sIdx) {
		if (sIdx == 2) {
			// temp 안 만들고 sel로 해버리니까 얕은 복사? 때문에 값이 다 바뀜;;;
			int[] temp = new int[2];
			for (int i = 0; i < 2; i++) {
				temp[i] = sel[i];
			}
			pairs.add(temp);

			return;
		}
		if (idx >= n) {
			return;
		}
		sel[sIdx] = idx;
		comb(n, idx + 1, sIdx + 1);
		comb(n, idx + 1, sIdx);
	}

	static void permutation(int count) {
		if (count == cnt) {
//			System.out.println("----------------");
//			for (int i = 0; i < cnt; i++) {
//				System.out.println(Arrays.toString(changingOrder[i]));
//			}
//			System.out.println("----------------");
			int num = 0;
			int[] newNums = new int[nums.length];
			for(int i = 0 ; i < nums.length; i++) {
				newNums[i] = nums[i];
			}
			for (int i = 0; i < changingOrder.length; i++) {
				swap(changingOrder[i], newNums);
			}
			for(int i = 0 ; i < nums.length;i++) {
				num += newNums[i] * Math.pow(10, newNums.length-1-i);
			}
//			System.out.println(num);
			if( num > answer) {
				answer = num;
			}
			return;
		}
		for (int i = 0; i < pairs.size(); i++) {
			int temp[] = new int[2];
			for (int j = 0; j < 2; j++) {
				temp[j] = pairs.get(i)[j];
			}
			changingOrder[count] = temp;
			permutation(count + 1);
		}
	}

	static void swap(int[] arr, int[] numArr) {
		int temp = numArr[arr[0]];
		numArr[arr[0]] = numArr[arr[1]];
		numArr[arr[1]] = temp;
		
	}

}
