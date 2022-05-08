package com.boj.day20220503;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1389_케빈베이컨 {
   public static void main(String[] args) {
	
      Scanner sc = new Scanner(System.in);
      
      int N=sc.nextInt();
      int M=sc.nextInt();
      
      //친구간 관계 
      int[][] arr= new int[N+1][N+1];
      
      for(int i=0;i<M;i++) {
         int a=sc.nextInt();
         int b=sc.nextInt();
         
         arr[a][b]++;
         arr[b][a]++;
      }

      //친구간 거리 최소값
      int[][] dp=new int[N+1][N+1];
      
      //while문 처리용
      int cnt=1;
      
      while(cnt<=N) {
 	  
    	  //방법.
    	  /*
    	   * 1부터 쭈욱 돌면서 dp를 구할 예정.
    	   * 랭크별로 들어간 애들을 기준으로 rank를 dp에 넣어주고 visited에 체크한다.
    	   * 그래서 마지막까지 들어간 경우, while문이 다음 것으로 반복한다(cnt++)
    	   * 
    	   * 
    	   * */
    	  
    	  //방문처리
          boolean[] visited= new boolean[N+1];
           
          //단계별 들어갈 숫자들 
          Queue<Integer> que = new LinkedList<>();
          
          que.add(cnt);
          visited[cnt]=true;
          
          //BFS rank버전 스타트 
          int size1=1;
          
          int checked=1;
          int rank=1;
          outer:
          while(true) {
        	  int size2=size1;
        	  size1=0;
        	  
        	  for(int i=0;i<size2;i++) {
            	  int num=que.poll();
            	  //이번 랭크에서 갈수 있는 모든 것들 체크하기 
            	  for(int j=1;j<=N;j++) {
            		  
            		  if(arr[num][j]!=0) {
            			  //다음번 행선지 
            			  que.add(j);
            			  size1++;
            			  //체크가 안되어있다면 최단거리 체크 
            			  if(!visited[j]) {
            				  dp[cnt][j]=rank;
                			  visited[j]=true;
                			  checked++;
                			  if(checked==N) {
                				  break outer;
                			  }
            			  }
            			  
            		  }
            		  
            	  }
              }
        	  //끝났으니 다음 랭크로 레벨업 
        	  rank++;
        	  if(rank>M) {
        		  break;
        	  }
          }
          
          cnt++;
      }
      //그러면 최소값 배열이 다 만들어졌다!! 그러면 1부터 N까지 돌면서 합의 최솟값만 찾으면 된다.
      int rIdx=0;
      int result=Integer.MAX_VALUE;
      for(int i=1;i<=N;i++) {
    	  int sum=0;
    	  for(int j=1;j<=N;j++) {
    		  sum+=dp[i][j];
    	  }
    	  if(result>sum) {
    		  rIdx=i;
    		  result=Math.min(result, sum);
    	  }
    	  
      }
      System.out.println(rIdx);
   }
}