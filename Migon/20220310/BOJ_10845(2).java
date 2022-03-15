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
		int[] queue = new int[10000];
		int idx = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push":
				queue[++idx] = Integer.parseInt(st.nextToken());
				break;
			case "front":
				if (idx >= 0) {
					bw.write(queue[0] + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "back":
				if (idx >= 0) {
					bw.write(queue[idx] + "\n");
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
			case "pop":
				if (idx >= 0) {
					bw.write(queue[0] + "\n");
					for (int j = 1; j <= idx; j++) {
						queue[j - 1] = queue[j];
					}
					queue[idx--] = 0;
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.close();
	}
}
