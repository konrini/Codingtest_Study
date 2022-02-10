import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1085 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int [] min = new int[4];
		min[0]=x;
		min[1] = y;
		min[2]=h-y;
		min[3]=w-x;
		
		int val=Arrays.stream(min).min().getAsInt();
		System.out.println(val);
	}

}
