package com.boj.day20220315;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
 
public class BOJ_10816_숫자카드2 {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);	
		
		int M = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int key = in.nextInt();
 
			
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
	}
 
 
	private static int lowerBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
 
		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {
 
			int mid = (lo + hi) / 2; // 중간위치를 구한다.
 
			if (key <= arr[mid]) {
				hi = mid;
			}
 
			else {
				lo = mid + 1;
			}
 
		}
 
		return lo;
	}
 
	private static int upperBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
 
		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {
 
			int mid = (lo + hi) / 2; // 중간위치를 구한다.
 
			// key값이 중간 위치의 값보다 작을 경우
			if (key < arr[mid]) {
				hi = mid;
			}
			// 중복원소의 경우 else에서 처리된다.
			else {
				lo = mid + 1;
			}
 
		}
 
		return lo;
	}
	
}