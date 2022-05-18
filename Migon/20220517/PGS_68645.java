import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 삼각형 정보를 담을 arr
        int[][] arr = new int[n][n];
        int row = -1; // 행
        int col = 0; // 열
        int len = n; // 연속해서 볼 개수
        int num = 1; // 넣을 숫자
        for (int i = 0; i < n; i += 3) {
            // 위에서 아래
            for (int j = 0; j < len; j++) {
                arr[++row][col] = num++;
            }
            len--;
            // 왼쪽에서 오른쪽
            for (int j = 0; j < len; j++) {
                arr[row][++col] = num++;
            }
            len--;
            // 아래에서 위
            for (int j = 0; j < len; j++) {
                arr[--row][--col] = num++;
            }
            len--;
        }
        // 정답 배열
        int[] answer = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}