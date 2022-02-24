import java.util.Scanner;

public class BOJ_14696_딱지놀이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 라운드 수

		for (int n = 1; n <= N; n++) {

			int a = sc.nextInt(); // A가 내는 딱지 수
			int[] ascore = new int[4];

			for (int i = 0; i < a; i++) {
				ascore[sc.nextInt() - 1]++;
			}

			int b = sc.nextInt();
			int[] bscore = new int[4];

			for (int i = 0; i < b; i++) {
				bscore[sc.nextInt() - 1]++;
			}

			int i = 3;
			while (i >= 0) {
				
				if (i == 0 && ascore[i] == bscore[i]) {
					System.out.println('D'); // 무승부
					break;
				}
				if (ascore[i] == bscore[i]) {
					i--;
					continue;
				}
				if (ascore[i] > bscore[i]) {
					System.out.println('A');
					break;
				} else if (ascore[i] < bscore[i]) {
					System.out.println('B');
					break;
				}
				
			}

		} // test case end

	}

}
