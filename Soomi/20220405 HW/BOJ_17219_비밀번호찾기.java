import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 저장된 사이트 주소 수
		int N = Integer.parseInt(st.nextToken());
		// 비밀번호 찾으려는 사이트 수
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> password = new HashMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			String site = st1.nextToken();
			String pw = st1.nextToken();
			password.put(site, pw);
		}

		for (int i = 0; i < M; i++) {
			String site = br.readLine();
			bw.write(password.get(site)+"\n");
		}

		bw.flush();
	}

}
