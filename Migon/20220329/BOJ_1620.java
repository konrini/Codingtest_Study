import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        // 포켓몬의 개수
        int N = Integer.parseInt(st.nextToken());
        // 내가 맞춰야 하는 문제의 개수
        int M = Integer.parseInt(st.nextToken());
        // 포켓몬 번호 -> 포켓몬 이름
        HashMap<Integer, String> pokemon_int = new HashMap<>();
        // 포켓몬 이름 -> 포켓몬 번호
        HashMap<String, Integer> pokemon_str = new HashMap<>();
        // 포켓몬 도감 채우기
        for (int i = 0; i < N; i++) {
            String pokemon = br.readLine();
            pokemon_int.put(i + 1, pokemon);
            pokemon_str.put(pokemon, i + 1);
        }
        for (int i = 0; i < M; i++) {
            // 숫자 혹은 문자열
            String command = br.readLine();
            try {
                int num = Integer.parseInt(command);
                bw.write(pokemon_int.get(num) + "\n");
            } catch (Exception e) {
                bw.write(pokemon_str.get(command) + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
