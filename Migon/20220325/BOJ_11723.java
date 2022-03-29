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
        int M = Integer.parseInt(br.readLine());
        // 집합 (1 ~ 20까지의 숫자만 넣음)
        int[] set = new int[21];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() + " ");
            String command = st.nextToken();
            int num;
            switch (command) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    // 비어있을 때 넣기
                    if (set[num] == 0) {
                        set[num] = 1;
                    }
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    // 있으면 1 출력, 없으면 0 출력
                    bw.write(set[num] + "\n");
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    // 있으면 없애기
                    if (set[num] == 1) {
                        set[num] = 0;
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    // 없으면 넣고, 있으면 없애기
                    set[num] = 1 - set[num];
                    break;
                case "empty":
                    // 다 없애기
                    for (int j = 1; j < set.length; j++) {
                        set[j] = 0;
                    }
                    break;
                case "all":
                    // 다 넣기
                    for (int j = 1; j < set.length; j++) {
                        set[j] = 1;
                    }
                    break;
            }
        }
        bw.close();
    }
}
