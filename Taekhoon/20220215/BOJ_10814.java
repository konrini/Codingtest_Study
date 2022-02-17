package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_10814 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 가입자 수
		int N = Integer.parseInt(bf.readLine());
		
		// 2차원 배열에 나이와 숫자를 넣기 위해 String 타입으로 배열 생성
		String[][] infos = new String[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			for(int j = 0; j < 2; j++) {
				infos[i][j] = st.nextToken();
			}
		}
		infos = countingSort(infos);
		for(int i = 0; i < N; i++) {
			System.out.printf("%s %s\n", infos[i][0], infos[i][1]);
		}
	}
	
	// 2차원 배열에서 각 인덱스의 0번째를 기준으로 정렬하는 카운팅 정렬
	public static String[][] countingSort(String[][] arr) {
		int len = arr.length;
		String[][] sorted = new String[len][2];
		int max = Integer.MIN_VALUE;
		
		// 이때 파라미터로 받은 2차원 배열이 문자열 형식이므로 Integer.parseInt로 정수화해줘야함.
		for(int i = 0; i< len; i++) {
			if(Integer.parseInt(arr[i][0])  > max) {
				max = Integer.parseInt(arr[i][0]);
			}
		}
		
		int[] count = new int[max+1];
		
		for(int i = 0; i < len; i++) {
			count[Integer.parseInt(arr[i][0])]++;
		}
		
		for(int j = 1; j < count.length; j++) {
			count[j] += count[j-1];
		}
		
		for(int i = len-1; i >= 0; i--) {
			sorted[--count[Integer.parseInt(arr[i][0])]] = arr[i];
		}
		return sorted;
	}
}
