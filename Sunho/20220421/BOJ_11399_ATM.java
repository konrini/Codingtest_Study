package com.boj.day20220421;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11399_ATM {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		//시간단축용으로 만들어봤는데 굳이 할 필요까지는 없었는듯....
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0;i<N;i++) {
			pq.add(sc.nextInt());
		}
		
		long sum=0;
		
		int cnt=N;
		
		//작은것부터 빼는데, 어차피 최대개수에서 줄어드는 만큼 더해질 것이기 때문에 그렇게 구현.
		while(!pq.isEmpty()) {
			
			int num=pq.poll();
			sum+=num*cnt;
			cnt--;
			
		}
		
		System.out.println(sum);
	}
}
