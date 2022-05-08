import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 걸리는 시간 저장 배열
        int temp[] = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++){
            // 남은 시간 일단 저장
            temp[i] = 100 - progresses[i];
            // 걸리는 시간으로 바꿔서 저장
            if(temp[i]%speeds[i]==0)
                temp[i] /= speeds[i];
            else
                temp[i] = temp[i]/speeds[i] +1;
        }
        
        List<Integer> list = new ArrayList<>();
        int now = temp[0];
        int cnt = 1;
        // temp 5 10 1 1 20 1 => 1 3 2  다음 값이 더 클때 초기화
        for(int i=1; i<temp.length; i++){
            if(now >= temp[i]){
                cnt++;
            }else{
                list.add(cnt);
                // 초기화
                cnt =1;
                now = temp[i];
            }
        }
        // 마지막 cnt 추가
        list.add(cnt);
        
        
        // list answer 배열에 옮기기
        int answer[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}