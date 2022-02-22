import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 총 라운드 수
		int N = Integer.parseInt(br.readLine());
		// 딱지놀이
		for (int i = 0; i < N; ++i) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			// A 카드 종류
			int A = Integer.parseInt(st1.nextToken());
			Integer[] A_cards = new Integer[A];
			for (int a = 0; a < A; ++a) {
				A_cards[a] = Integer.parseInt(st1.nextToken());
			}
			// A 카드 내림차순 정리
			Arrays.sort(A_cards, Collections.reverseOrder());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			// B 카드 종류
			int B = Integer.parseInt(st2.nextToken());
			Integer[] B_cards = new Integer[B];
			for (int b = 0; b < B; ++b) {
				B_cards[b] = Integer.parseInt(st2.nextToken());
			}
			// B 카드 내림차순 정리
			Arrays.sort(B_cards, Collections.reverseOrder());
			// 정답
			String ans = "";
			// 길이가 짧은 카드 뭉치 선택
			int min = A > B ? B : A;
			// 값 비교
			for (int idx = 0; idx < min; ++idx) {
				if (A_cards[idx] > B_cards[idx]) {
					ans = "A";
					break;
				} else if (B_cards[idx] > A_cards[idx]) {
					ans = "B";
					break;
				}
			}
			// 위에서 결판이 안났을 때
			if (ans == "" && A_cards.length == B_cards.length) {
				ans = "D";
			} else if (ans == "" && A_cards.length > B_cards.length) {
				ans = "A";
			} else if (ans == "" && B_cards.length > A_cards.length) {
				ans = "B";
			}
			bw.write(ans + "\n");
		}
		bw.close();
	}
}