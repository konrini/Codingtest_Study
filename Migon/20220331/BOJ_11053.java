import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int index = 0;
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arr[index] < num) {
                arr[++index] = num;
            } else if (arr[index] > num) {
                for (int j = 0; j <= index; j++) {
                    if (num <= arr[j]) {
                        arr[j] = num;
                        break;
                    }
                }
            }
        }
        System.out.println(index + 1);
    }
}