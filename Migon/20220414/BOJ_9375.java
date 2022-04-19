import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static int[] arr;
    static int[] visited;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
	    // 의상의 수
            int n = Integer.parseInt(br.readLine());
	    // key : 의상의 종류, value : 해당 의상의 종류의 갯수
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine() + " ");
                st.nextToken(); // 어떤 의상인지 상관 없어서 버림.
                String type = st.nextToken(); // 의상 종류
                if (!map.containsKey(type)) {
                    map.put(type, 1);
                } else {
                    map.put(type, map.get(type) + 1);
                }
            }
            int ans = 1;
            for (String type : map.keySet()) {
		// 각 의상 종류에 + 1을 하여 곱한다. (선택 안하는 경우)
                ans *= map.get(type) + 1;
            }
	    // 모두 선택 안했을 때를 빼준다.
            bw.write(ans - 1 + "\n");
        }
        bw.close();
    }

}