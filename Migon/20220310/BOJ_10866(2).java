import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] deque = new int[10000];
		int idx = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push_front":
				for (int j = idx; j >= 0; j--) {
					deque[j + 1] = deque[j];
				}
				deque[0] = Integer.parseInt(st.nextToken());
				++idx;
				break;
			case "push_back":
				deque[++idx] = Integer.parseInt(st.nextToken());
				break;
			case "front":
				if (idx >= 0) {
					bw.write(deque[0] + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "back":
				if (idx >= 0) {
					bw.write(deque[idx] + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "empty":
				if (idx >= 0) {
					bw.write("0\n");
				} else {
					bw.write("1\n");
				}
				break;
			case "size":
				bw.write((idx + 1) + "\n");
				break;
			case "pop_front":
				if (idx >= 0) {
					bw.write(deque[0] + "\n");
					for (int j = 1; j <= idx; j++) {
						deque[j - 1] = deque[j];
					}
					deque[idx--] = 0;
				} else {
					bw.write("-1\n");
				}
				break;
			case "pop_back":
				if (idx >= 0) {
					bw.write(deque[idx] + "\n");
					deque[idx--] = 0;
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.close();
	}
}
