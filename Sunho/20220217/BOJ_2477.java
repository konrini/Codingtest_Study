package com.boj.day20220217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		int[][] arr = new int[6][2];
		
		/* 육각형 특징상 한쪽이 파이게 된다. 그렇기 때문에 최대 길이를 구하고, input중에서 최대길이가 아닌 경우 파이는 부분 시작이기 때문에 그 부분을 없애버리면 된다.*/
		int maxWidth=0;
		//잘라지지 않는 부분의 가로 인덱스 확인
		int maxWIdx=-1;
		
		
		int maxheight=0;
		//잘라지지 않는 부분의 세로 인덱스 확인
		int maxHIdx=-1;
		
		for(int i=0;i<6;i++) {
			
			String[] str = br.readLine().split(" ");
			
			arr[i][0]=Integer.parseInt(str[0]);
			arr[i][1]=Integer.parseInt(str[1]);
			
			//최대값 설정
			if(Integer.parseInt(str[0])<3) {
				if(maxWidth<Integer.parseInt(str[1])) {
					maxWidth=Integer.parseInt(str[1]);
					maxWIdx=i;
				}
				
				
			}else {
				if(maxheight<Integer.parseInt(str[1])) {
					maxheight=Integer.parseInt(str[1]);
					maxHIdx=i;
				}
			}
		}
		
		int surface=maxWidth*maxheight;
		
		//어차피 둘은 모양 특성상 붙어있을 수밖에 없다. 그래서 둘중 큰 부분만 찾으면, 큰것을 기준으로 앞의 두번쨰와 세번째가 빠지는 사각형의 가로,세로가 된다.
		int targetIdx=Math.max(maxWIdx, maxHIdx);
		
		//그냥 두개 붙여서 쉽게 생각해버리자. 그래서 그것을 기준으로 targetIdx+2와 targetIdx+3만 찾아서 넓이를 빼버리면 된다.
		int[][] results = new int[12][2];
		
		
		
		for(int i=0;i<12;i++) {
			
			results[i]=arr[i%6];
		}
		
		
		if(Math.max(maxWIdx, maxHIdx)==5 && Math.min(maxWIdx, maxHIdx)==0) {
			surface-=results[2][1]*results[3][1];
		}else {
			
			surface-=results[targetIdx+2][1]*results[targetIdx+3][1];
		}
		
		
		
		
		
		
//		//0과 6인 경우는 어쩔 수없이 떨어져있기 때문에 그 부분만 조심해주면 된다.
//		if(targetIdx==6 && Math.min(maxWIdx, maxHIdx)==0) {
//			//2,3
//			surface-=arr[2][1]*arr[3][1];
//		
//		//그렇지 않은 경우, 2와 3만큼 늘려서 곱해주면 되는데, 인덱스를 넘어가는 경우도 있기 때문에 나머지처리를 해준다.
//		}else {
//			
//			//System.out.println("빼기 사각형 : "+arr[(targetIdx+2)%6][1]*arr[(targetIdx+3)%6][1]);
//			surface-=arr[(targetIdx+2)%6][1]*arr[(targetIdx+3)%6][1];
//		}
//		
		
		System.out.println(num*surface);
		
		
		
	}
}
