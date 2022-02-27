package com.sw.day20220226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
 
public class 러시아_국기_같은_깃발 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int t=Integer.parseInt(br.readLine());
         
        for(int idx=1;idx<=t;idx++) {
             
            String[] a = br.readLine().split(" ");
             
            int N=Integer.parseInt(a[0]);
            int M=Integer.parseInt(a[1]);
             
            char[][] arr= new char[N][M];
            for(int i=0;i<N;i++) {
                char[] b= br.readLine().toCharArray();
                 
                for(int j=0;j<M;j++) {
                    arr[i][j]=b[j];
                }
            }
            //줄 나눠질 수 있는 모든 경우의 수 다 담아두기!! 
            Map<Integer,int[]> map = new HashMap<>();
             
            int mapCnt=0;
            //white color
            for(int i=1;i<=N-2;i++) {
                //blue color(-1은 red도 하나는 줘야하니까!)s
                for(int j=1;j<=N-i-1;j++) {
                    //red color
                    int[] temp= {i,j};
                     
                    map.put(mapCnt, temp);
                    mapCnt++;
                     
                }
            }
             
            //map의 사이즈만큼 돌리면서 국기의 모든 경우 다 살펴보기
            int min=Integer.MAX_VALUE;
            for(int i=0;i<map.size();i++) {
                 
                int[] cases=map.get(i);
                int cnt=0;
                 
                for(int j=0;j<N;j++) {
                    for(int k=0;k<M;k++) {
                         
                        if(j<cases[0]) {
                             
                            if(arr[j][k]!='W') {
                                cnt++;
                            }
                        }else if(cases[0]<=j && j<cases[0]+cases[1]) {
                            if(arr[j][k]!='B') {
                                cnt++;
                            }
                        }else if(j>=cases[0]+cases[1]){
                            if(arr[j][k]!='R') {
                                cnt++;
                            }
                        }
                         
                         
                         
                    }
                }
                 
                if(min>cnt) {
                    min=cnt;
                }
            }
             
            System.out.printf("#%d %d\n",idx,min);
            //System.out.println("======================");
        }
    }
}
