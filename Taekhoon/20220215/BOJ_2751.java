package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_2751 {
	public static void main(String[] args) throws IOException {
		// 스캐너로는 시간초과가 되는거같음 ㅠㅠ
		Scanner sc = new Scanner(System.in);
		// bufferedReader사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		

		
		
		// 수의 개수 
		int N = Integer.parseInt(bf.readLine());
		
		// 입력 값들을 저장할 배열
		int[] nums = new int[N];
		
		// 입력된 값 배열에 저장
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(bf.readLine());
		}
		
//		bubbleSort(nums);
		selectionSort(nums);
//		nums = countingSort(nums);
		for(int i =0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	
	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		for(int i = 0; i < len-1; i ++) {
			for(int j = 1; j < len-i; j++) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		
	}
	
	public static void selectionSort(int[] arr) {
		int len = arr.length;
		for(int i = 0; i < len - 1; i++) {
			int minIdx = i;
			for(int j = i; j < len; j++) {
				if(arr[j] < arr[minIdx]) minIdx = j;
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
	}
	
	public static int[] countingSort(int[] arr) {
		int len = arr.length;
		int[] sorted = new int[len];
		int max = Integer.MIN_VALUE;
		
		// 배열의 값 중 최솟값이 음수인 경우 최솟값을 0으로 세팅 후 카운팅알고리즘 수행해야함
		// 정렬이 다 된 다음 다시 더해준 값만큼 뺴주기.
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < len; i++) {
			// 음수이면서 최솟값을 min에 저장
			if( arr[i] < 0 && arr[i] < min) {
				min = arr[i];
			}
		}
		// 최솟값이 음수인 경우 그 값이 0이 되게끔 shift
		if(min < 0) {
			for(int i =0 ;i < len; i++) {
				arr[i] -= min;
			}
		}
		// shift된 상태에서 배열 중 최댓값을 찾는다.
		for(int i = 0; i< len; i++) {
			if(arr[i]  > max) {
				max = arr[i];
			}
		}
		
		int[] count = new int[max+1];
		
		for(int i = 0; i < len; i++) {
			count[arr[i]]++;
		}
		
		for(int j = 1; j < count.length; j++) {
			count[j] += count[j-1];
		}
		
		for(int i = len-1; i >= 0; i--) {
			sorted[--count[arr[i]]] = arr[i];
		}
		// 최솟값이 음수인 경우 shift해준만큼 다시 돌려놓기
		if(min < 0) {
			for(int i = 0; i < len; i++) {
				sorted[i] += min;
			}
		}
		return sorted;
		// arr = sorted; 이렇게 하고 위에서 countingSort(nums); 하면 nums가 정렬 안되는이유....??
		// arr로 받아온 nums의 주소값에다가 sorted가 저장된 주소값을 줬는데 sorted가 함수안에서 사라져서?

	}
}
