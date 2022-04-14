import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main3 {
    static int[] arr;
    static int[] visited;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 테스트 케이스의 수
	int T = Integer.parseInt(br.readLine());
        int[] arr = new int[12]; // 최대 11까지 부여됨.
        arr[1] = 1; // 1
        arr[2] = 2; // 1+1, 2
        arr[3] = 4; // 1+1+1, 1+2, 2+1, 3
        for (int i = 4; i <= 11; i++) {
	    // 하나 더하고, 둘을 더하고, 셋을 더한다.
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[n] + "\n");
        }
        bw.close();
    }

}