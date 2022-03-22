import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int K = sc.nextInt();
        // 숫자 모음
        Queue<Integer> nums = new LinkedList<>();
        // 숫자 넣기
        for (int i = 1; i <= N; i++) {
            nums.add(i);
        }
        bw.write("<");
        while (nums.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                nums.add(nums.poll());
            }
            bw.write(nums.poll() + ", ");
        }
        bw.write(nums.poll() + ">");
        bw.close();
    }
}