package programmers;

import java.util.*;

class main {
    static int[][] arr; // 달팽이 배열
    
    public int[] solution(int n) {
        
        int num = 1; // 차례로 쓰여지는 숫자
        // 달팽이 배열 초기화
        arr = new int[n][];
        for(int i = 0; i < n; i++){
            arr[i] = new int[i+1];
        }
        snail(1,0,0,n);
        // for(int i = 0 ; i < n; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
        int size = n*(n+1) / 2;
        int[] answer = new int[size]; // 정답 배열
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
    // 적힐 숫자, 시작 위치(행,열), 달팽이 배열의 크기를 받으면 숫자를 써주는 메서드
    static void snail(int num, int row, int col, int n){
        // n이 1인 경우
        if(n == 1){
            arr[row][col] = num;
        } else { // n이 3보다 큰 경우
            // 이번에 적힐 숫자의 개수 cnt
            int cnt = n * 3 - 3;
            // 행 증가시키면서 숫자 채우기
            for(int i = 0 ; i < n; i++){
                arr[row + i][col] = num++;
            }
            // 열 증가시키면서 숫자 채우기
            for(int i = 1; i <= n-1; i++){
                arr[row+(n-1)][col+i] = num++;
            }
            // 열과 행 1씩 감소 시키면서 숫자 채우기
            for(int i = 1; i <= n-2; i++){
                arr[row+(n-1) -i][col+(n-1) -i] = num++;
            }
            // 사이즈가 2,3 이면 재귀호출 x
            if(n == 2 || n == 3) {
            	return;
            	
            // 사이즈가 4이상이면 재귀호출
            } else {
            	// 다음 사이즈 재귀로 호출
            	snail(num, row+2, col+1, n-3);
            }
        }
    }
}