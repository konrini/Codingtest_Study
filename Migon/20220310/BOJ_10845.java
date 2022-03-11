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
		List<Integer> queue = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push":
				queue.add(Integer.parseInt(st.nextToken()));
				break;
			case "front":
				if (queue.size() > 0) {
					bw.write(queue.get(0) + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "back":
				if (queue.size() > 0) {
					bw.write(queue.get(queue.size()-1) + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "empty":
				if (queue.size() > 0) {
					bw.write("0\n");
				} else {
					bw.write("1\n");
				}
				break;
			case "size":
				bw.write(queue.size() + "\n");
				break;
			case "pop":
				if (queue.size() > 0) {
					bw.write(queue.remove(0) + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.close();
	}
}