import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		List<String> words = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			String word = br.readLine();
			// 중복값 제거해서 넣기
			if (!(words.contains(word))) {
				words.add(word);
			}
		}
		// 2초안에 풀어야 하는데 배운 버블 정렬과 선택 정렬을 사용하면 시간 내로 풀 수 없다.
		// 최악의 경우 4억번 이상의 연산을 해야하기 때문이다.

		// Collections.sort 메서드 => Tim sort
		// Arrays.sort 메서드 => Dual-Pivot QuickSort

		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String word1, String word2) {
				// 만약 길이가 같으면 사전순으로
				if (word1.length() == word2.length()) {
					return word1.compareTo(word2);
				}
				return Integer.compare(word1.length(), word2.length());
			}
		});
		for (String ans : words) {
			bw.write(ans + "\n");
		}
		bw.close();
	}
}
