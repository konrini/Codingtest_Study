package com.boj.day20220517;

public class PGS_68645_삼각달팽이 {
	class Solution {
	    public int[] solution(int n) {
	        
	        int[] arr = new int[n*(n+1)/2];
	        
	        
	        //시작 횟수
	        int idx=0;
	        
	        //변의 길이
	        int side=n-1;
	        
	        int cnt=1;
	        
	        while(side>=0){    
	            //시작줄
	            int stLine=2*idx;
	            
	            for(int i=stLine;i<stLine+side;i++){
	                arr[(i*(i+1)/2)+idx]=cnt;
	                cnt++;
	            }
	            
	            ///////두번째
	            int second=((stLine+side)*(stLine+side+1)/2)+idx;
	            
	            for(int i=second;i<=second+side;i++){
	                arr[i]=cnt;
	                cnt++;
	            }
	            
	            ////////세번째
	            int third=((stLine+side)*(stLine+side+1)/2)-idx-1;
	            
	            for(int i=stLine+side;i>stLine+1;i--){
	                arr[(i*(i+1)/2)-idx-1]=cnt;
	                cnt++;
	            }
	            
	            
	            idx++;
	            side-=3;
	        }
	        
	        
	        return arr;
	    }
	}
}
