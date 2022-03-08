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
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; ++i) {
			// 열린 괄호 담을 리스트
			List<Character> stack = new ArrayList<>();
			String str = br.readLine();
			// 올바른 괄호 문자열인지
			String ans = "YES";
			for (int j = 0; j < str.length(); ++j) {
				// 열린 괄호 넣기
				if (str.charAt(j) == '(') {
					stack.add(str.charAt(j));
				} else {
					// 세트가 안 맞을 때
					if (stack.size() == 0) {
						ans = "NO";
						break;
					} else {
						stack.remove(stack.size() - 1);
					}
				}
			}
			// 열린 괄호가 남아있을 때
			if (stack.size() > 0) {
				ans = "NO";
			}
			bw.write(ans + "\n");
		}
		bw.close();
	}
}
