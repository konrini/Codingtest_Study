import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		// 그룹 단어의 개수
		int cnt = 0;
		for (int i = 0; i < K; ++i) {
			// 문자 하나씩 담을 리스트
			List<Character> list = new ArrayList<>();
			String word = br.readLine();
			// 그룹 단어인지 확인
			boolean check = true;
			for (int j = 0; j < word.length(); ++j) {
				// 첫 글자는 넣기
				if (j == 0) {
					list.add(word.charAt(j));
				} else {
					// 새로 들어올 문자가 리스트에 존재할 때, 리스트의 마지막 문자와 같은지 확인
					if (list.contains(word.charAt(j))) {
						if (list.get(list.size() - 1) == word.charAt(j)) {
							list.add(word.charAt(j));
						} else {
							check = false;
							break;
						}
					} 
					// 새로 들어올 문자가 처음 들어왔을 때
					else {
						list.add(word.charAt(j));
					}
				}
			}
			if (check) {
				++cnt;
			}
		}
		bw.write(cnt + "");
		bw.close();
	}
}