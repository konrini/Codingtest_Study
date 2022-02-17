import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		// 나이와 이름의 정보 받기
		String[][] info = new String[N][2];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = st.nextToken();
			info[i][1] = st.nextToken();
		}
		Arrays.sort(info, new Comparator<String[]>() {
			@Override
			// 나이순으로 정렬
			public int compare(String[] info1, String[] info2) {
				return Integer.parseInt(info1[0]) - Integer.parseInt(info2[0]);
			}
		});
		for (int i = 0; i < N; ++i) {
			bw.write(info[i][0] + " " + info[i][1] + "\n");
		}
		bw.close();
	}
}