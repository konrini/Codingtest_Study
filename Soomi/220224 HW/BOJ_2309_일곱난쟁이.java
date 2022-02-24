import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] height = new int[9];

		int allsum = 0;
		for (int i = 0; i < 9; i++) {
			allsum += height[i] = sc.nextInt();
		}
		Arrays.sort(height);

		int sum = 0;
		int not1 = 0;
		int not2 = 0;
		finding: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				sum = height[i] + height[j];

				if (sum == allsum - 100) {
					not1 = i;
					not2 = j;
					break finding;
				}
			}
		} // end finding

		for(int i=0;i<9;i++) {
			if(i==not1 || i==not2) {
				continue;
			}else
			System.out.println(height[i]);
		}
	}

}
