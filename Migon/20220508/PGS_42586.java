class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 작업 기간 (올림 처리)
        double[] time = new double[progresses.length];
        for (int i = 0; i < progresses.length; ++i) {
            time[i] = Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }
        // now : 현재 작업 기간
        // 초기값 : 처음 작업의 작업 기간
        double now = time[0];
        // 같이 배포할 작업의 수를 담은 배열
        int[] list = new int[progresses.length];
        // 처음 작업은 처음에 배포할 것이므로
        list[0] = 1;
        // 같이 배포할 것인지 보는 인덱스
        int idx = 0;
        // 배포의 수
        int cnt = 1;
        for (int i = 1; i < time.length; ++i) {
            // 만약 다음 작업보다 일찍 끝나면 배포
            if (now < time[i]) {
                // 다음 작업 시작
                list[++idx]++;
                // 배포 수 증가
                cnt++;
                // 다음 작업의 작업 기간
                now = time[i];
            } 
            // 다음 작업도 같이 배포
            else if (now >= time[i]) {
                list[idx]++;
            }
        }
        // 정답 배열
        int[] answer = new int[cnt];
        for (int i = 0; i < cnt; ++i) {
            answer[i] = list[i];
        }
        return answer;
    }
}