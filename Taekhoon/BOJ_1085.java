package boj.class2;

import java.util.Scanner;

public class Boj_1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int[] distances = new int[4];
		distances[0] = x;
		distances[1] = w -x;
		distances[2] = y;
		distances[3] = h-y;
		int max = distances[0];
		for (int i = 0; i < 4; i++) {
			if(distances[i] < max) {
				max = distances[i];
			}
		}
		System.out.println(max);
	}
}
