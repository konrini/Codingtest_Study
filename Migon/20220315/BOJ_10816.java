import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 상근이가 가지고 있는 숫자 카드의 개수
        int N = Integer.parseInt(br.readLine());
        // 숫자와 개수를 담을 map
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st1.nextToken());
            // 숫자가 map에 key로 있는지 확인
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int check = Integer.parseInt(st2.nextToken());
            // 존재할 때
            if (map.containsKey(check)) {
                bw.write(map.get(check) + " ");
            } else {
                bw.write("0 ");
            }
        }
        bw.close();
    }
}
