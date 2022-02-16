package boj.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = sc.next();
		}
		byLength(words);
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		words = byDict(words);
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
	}

	public static String[] byDict(String[] arr) {
		int N = arr.length;
		char[][] wordChar = new char[N][];
		int[] wordlen = new int[arr[N - 1].length()];
		for (int i = 0; i < N; i++) {
			wordlen[arr[i].length() - 1]++;
		}
		for (int i = 0; i < N; i++) {
			wordChar[i] = new char[arr[i].length()];
			for (int j = 0; j < arr[i].length(); j++) {
				wordChar[i][j] = (arr[i].charAt(j));
			}
			System.out.println(Arrays.toString(wordChar[i]));
		}
		int[] range = new int[wordlen.length + 1];
		for (int i = 0; i < wordlen.length; i++) {
			for (int j = 0; j < i; j++) {
				range[i] += wordlen[j];
			}
		}
		range[wordlen.length] = range[wordlen.length - 2] + wordlen[wordlen.length - 1];
		System.out.println("range=   "+ Arrays.toString(range));
		for (int m = 0; m < range.length - 1; m++) {
			int lower = range[m];
			int upper = range[m + 1];
			int M = upper - lower;
			System.out.printf("lower: %d, upper: %d\n", lower, upper);
			for(int i = lower; i< lower + M -1;i++) {
				for(int k = 0; k < upper)
			}
		}
		String[] ans = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ans[i] = "";
			for (int j = 0; j < wordChar[i].length; j++) {
				ans[i] += wordChar[i][j];
			}
		}
		return ans;
	}
	
	public static void compareWord(char[][] arr) {
		
	}
	
	public static void byLength(String[] arr) {
		int len = arr.length;
		int[] lenArr = new int[len];

		for (int i = 0; i < len; i++) {
			lenArr[i] = arr[i].length();
		}

		for (int i = len - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (lenArr[j] > lenArr[j + 1]) {
					int temp = lenArr[j];
					String word_temp = arr[j];
					lenArr[j] = lenArr[j + 1];
					lenArr[j + 1] = temp;

					arr[j] = arr[j + 1];
					arr[j + 1] = word_temp;
				}
			}
		}
	}
}
