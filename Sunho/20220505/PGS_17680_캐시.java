package com.boj.day20220503;

import java.util.LinkedList;
public class PGS_17680_캐시 {

	class Solution {
	    public int solution(int cacheSize, String[] cities) {
	        
	        //이름의 유무 확인용 
	        LinkedList<String> list = new LinkedList<>();
	        
	        int result=0;
	        for(int i=0;i<cities.length;i++){
	            
	            if(cacheSize==0){
	                result=cities.length*5;
	                break;
	            }
	            
	            
	            String str = cities[i].toUpperCase();
	            
	            //cache hit : 도시가 있음
	            //그렇기 떄문에 그냥 없애고 마지막에 하나 추가해주면 된다.
	            if(list.contains(str)){
	                list.remove(str);
	                list.add(str);
	                result++;
	            }
	            //cache miss : 도시가 없음 
	            else{
	                //사이즈가 꽉 차면 맨 앞에꺼 제거하고 넣기
	                if(list.size()==cacheSize){
	                    //맨 앞에 제거
	                    list.poll();
	                }
	                
	                //맨 뒤에 추가
	                list.add(str);
	                result+=5;
	            }
	        }
	        
	        
	        
	        return result;
	    }
	}
}
