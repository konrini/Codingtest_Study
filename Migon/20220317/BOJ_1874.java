import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        // 수열
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 스택
        Stack<Integer> stack = new Stack<>();
        // 수열에서 참조하고 있는 index
        int idx = 0;
        // 넣을 숫자 (1부터 n까지)
        int i = 1;
        while (idx < n) {
            // 만약 수열에서 뽑아낼 숫자가 스택에 없을 때
            if (i <= arr[idx]) {
                stack.add(i++);
                sb.append("+\n");
            } else {
                // 수열에서 뽑아낼 숫자가 스택의 마지막 숫자와 같을 때
                if (stack.peek() == arr[idx]) {
                    stack.pop();
                    sb.append("-\n");
                    ++idx;
                } else {
                    // StringBuilder 초기화
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}