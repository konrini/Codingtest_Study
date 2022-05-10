package com.boj.day20220508;

import java.util.ArrayList;
public class PGS_42586_기능개발 {

	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        
	        //차이를 담아둘 배열 
	        int[] days = new int[progresses.length];
	        
	        for(int i=0;i<days.length;i++){
	            int remain= 100-progresses[i];
	            
	            //올림처리. 함수로 표현하기 힘들어서 이렇게 처리
	            if(remain%speeds[i]==0){
	                days[i]=(int)remain/speeds[i];
	            }else{
	                days[i]=(int)remain/speeds[i]+1;
	            }
	        }
	        
	        
	        //이제 days를 돌면서 최대값이 갱신될 때를 찾자.
	        //뒤에 최대값으로 바뀌면 그 부분은 이후에 진행될 부분들이기 때문!
	        
	        //최대값 갱신 포인트 넣어두기 
	        ArrayList<Integer> list = new ArrayList<>();
	        list.add(0);//list의 차이를 계산할 건데, 맨 앞부분이 -1로 들어가 있어야 결과맞음
	        
	        
	        
	        int max=days[0];
	        
	        for(int i=1;i<days.length;i++){
	            if(days[i]>max){
	                list.add(i);
	                max=days[i];
	            }
	        }
	        //마지막 부분 세어줘야하기 때문에 넣어줌 
	        list.add(days.length);
	        
	        int[] answer= new int[list.size()-1];
	        for(int i=1;i<list.size();i++){
	            answer[i-1]=list.get(i)-list.get(i-1);
	        }
	        
	        return answer;
	    }
	}
}
