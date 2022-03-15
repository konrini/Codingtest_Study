import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		List<Integer> deque = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push_front":
				deque.add(0, Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (deque.size() > 0) {
					bw.write(deque.remove(0) + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "pop_back":
				if (deque.size() > 0) {
					bw.write(deque.remove(deque.size() - 1) + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "empty":
				if (deque.size() > 0) {
					bw.write("0\n");
				} else {
					bw.write("1\n");
				}
				break;
			case "size":
				bw.write(deque.size() + "\n");
				break;
			case "front":
				if (deque.size() > 0) {
					bw.write(deque.get(0) + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "back":
				if (deque.size() > 0) {
					bw.write(deque.get(deque.size() - 1) + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.close();
	}
}