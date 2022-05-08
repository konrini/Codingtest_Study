package com.boj.day20220428;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class conferences {
	public int st;
	public int ed;
	
	public conferences(int st, int ed) {
		super();
		this.st = st;
		this.ed = ed;
	}
	
}

public class BOJ_1931_희의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		//회의를 종료시점 기준으로 정렬하자.
		conferences[] arr = new conferences[N];
		
		
		for(int i=0;i<N;i++) {
			int st=sc.nextInt();
			int ed=sc.nextInt();
			arr[i]=new conferences(st, ed);
		}
		
		Arrays.sort(arr,new Comparator<conferences>() {

			@Override
			public int compare(conferences o1, conferences o2) {
				
				if(o1.ed==o2.ed) {
					return o1.st-o2.st;
				}
				
				return o1.ed-o2.ed;
			}
		});

		//이전 가장 빠른 종료
		int preEd=0;
		int cnt=0;
		
		for(int i=0;i<arr.length;i++) {
			//이 종료보다 나중에 시작하면, 바로 넣어준다. 정렬되어있기 때문에 처음 나오는 것이 가장 빠르게 시작하고 빠르게 끝나는 것이 들어가게 된다.
			if(arr[i].st>=preEd) {
				cnt++;
				preEd=arr[i].ed;
			}
			
			
		}
		
		System.out.println(cnt);
		
	}
}