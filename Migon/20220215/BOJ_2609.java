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
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 공배수
		int cf = 0;
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		// 작은 수 찾기
		if (num1 <= num2)
			cf = num1;
		else
			cf = num2;
		// 최대 공약수 찾기
		for (int i = cf; i >= 1; --i) {
			if (num1 % i == 0 && num2 % i == 0) {
				cf = i;
				bw.write(i + "\n");
				bw.flush();
				break;
			}
		}
		// 최소 공배수 찾기
		bw.write(String.valueOf(cf * (num1 / cf) * (num2 / cf)));
		bw.close();
	}
}