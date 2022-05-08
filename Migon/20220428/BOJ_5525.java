import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 수열 N값
        int N = sc.nextInt();
        // 문자열 길이
        int M = sc.nextInt();
        // 문자열
        String str = sc.next();
        // 카운팅
        int cnt = 0;
        // O(N)의 방법
        for (int i = 0; i < M; i++) {
            // 올바른 문자열의 길이
            double len = 0;
            // I로 시작할 때 시작하니까
            if (str.charAt(i) == 'I') {
                // 문자열 탐색
                int j = 0;
                for (j = 0; j < M - i; j++) {
                    // 2의 배수 자리에는 I
                    if (j % 2 == 0) {
                        if (str.charAt(i + j) == 'I') {
                            len++;
                            continue;
                        }
                    }
                    // 아닐 때 자리에는 O
                    else {
                        if (str.charAt(i + j) == 'O') {
                            len++;
                            continue;
                        }
                    }
                    // 만약 올바르지 않을 때
                    break;
                }
                if (len >= 2 * N + 1) {
                    // I가 몇 개 시작할 수 있는지 보기
                    cnt += Math.ceil((len + 1 - (2 * N + 1)) / 2);
                }
                // 본만큼 이동
                i += j - 1;
            }
        }
        // 출력
        System.out.println(cnt);
    }
}