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
		while (true) {
			String line = br.readLine();
			// 짝꿍 맞는지 체크
			boolean check = true;
			// 종료
			if (line.equals(".")) {
				break;
			}
			// 괄호 담을 리스트
			List<String> list = new ArrayList<>();
			for (int i = 0; i < line.length(); ++i) {
				if (line.charAt(i) == '(') {
					list.add("(");
				} else if (line.charAt(i) == ')') {
					if (list.size() > 0) {
						// 짝꿍일 때
						if (list.get(list.size() - 1) == "(") {
							list.remove(list.size() - 1);
						}
						// 짝꿍이 아닐 때
						else {
							bw.write("no\n");
							check = false;
							break;
						}
					}
					// 짝이 안 맞을 때
					else {
						bw.write("no\n");
						check = false;
						break;
					}
				}
				// 대괄호에 대해서도 똑같이
				else if (line.charAt(i) == '[') {
					list.add("[");
				} else if (line.charAt(i) == ']') {
					if (list.size() > 0) {
						if (list.get(list.size() - 1) == "[") {
							list.remove(list.size() - 1);
						} else {
							bw.write("no\n");
							check = false;
							break;
						}
					} else {
						bw.write("no\n");
						check = false;
						break;
					}
				}
			}
			if (check == true) {
				// 열린 괄호가 남았을 때
				if (list.size() > 0) {
					bw.write("no\n");
				} else {
					bw.write("yes\n");
				}
			}
		}
		bw.close();
	}
}