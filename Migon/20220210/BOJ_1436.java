import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		// 666이 포함된 숫자 개수 세기
		int cnt = 0;
		// 숫자
		String num = "666";
		while (true) {
			if (num.contains("666")) {
				cnt++;
				if (N == cnt) {
					break;
				}
			}
			// 숫자 1씩 더하기
			num = Integer.parseInt(num) + 1 + "";
		}
		bw.write(num);
		bw.close();
	}
}
