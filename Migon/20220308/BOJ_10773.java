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
		// 정수 K
		int K = Integer.parseInt(br.readLine());
		// 숫자 담을 리스트
		List<Integer> list = new ArrayList<>();
		// 최종적으로 남은 수의 합
		int sum = 0;
		for (int i = 0; i < K; ++i) {
			int num = Integer.parseInt(br.readLine());
			// 0 들어오면 지워
			if (num == 0) {
				// 합에서도 지워
				sum -= list.get(list.size() - 1);
				list.remove(list.size() - 1);
			} else {
				// 합에도 더하고, 리스트에도 넣어줘
				sum += num;
				list.add(num);
			}
		}
		bw.write(sum + "");
		bw.close();
	}
}