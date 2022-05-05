package com.boj.day20220428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_5525_IOIOI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());//S의 길이 
		
		char[] S = br.readLine().toCharArray();
		
		int idx=0;
		
		//현재 반복구간인지 체크 
		boolean check=false;
		//반복구간 중 다음 문자열 비교용 
		char pre='I';
		//반복구간의 길이 세팅 
		int cnt=0;
		
		//반복되는 구간 크게크게 잘라넣을 때의 길
		List<Integer> sList=new ArrayList<>();
		
		while(idx<M) {
			
			//현재 반복구간 중 
			if(check) {
				//앞의 문자열과 다른 경우. 계속 간다 
				if(S[idx]!=pre) {
					pre=S[idx];
					cnt++;
				
				//문자열이 같은 경우. 즉 반복의 끝 
				}else {
					//반복 끄기 
					check=false;
					
					//총 길이. -1을 해야 I로 끝날 때와 O로 끝날 때 모두 정상적인 사이즈 길이로 들어감. 이곳이 Pn의 n부분임 
					int size=(cnt-1)/2;
					
					//최소 N을 넘어야 길이가 맞기 때문에, 이거 체크해서 넣어주기 
					if(size>=N) {
						sList.add(size);
					}
					
					//cnt 리셋 
					cnt=0;
					//pre 리셋
					pre='I';
					//이번 것을 다시 볼 필요가 있음. 왜냐하면 끝이면서 새로운 반복의 시작일 수 있기 때문!!
					idx--;
				}
				
				
			//반복구간은 아닌데 I가 들어오는 경우. 즉, 반복구간의 시작 	
			}else if(!check && S[idx]=='I') {
				cnt++;
				check=true;
			}
			
			idx++;
		}
		
		//마지막 부분까지 다 돌면 위의 while문에서 마지막 부분이 안빠지기 때문에 이것만 빼내보자 
		if(cnt!=0) {
			int size=(cnt-1)/2;
			
			if(size>=N) {
				sList.add(size);
			}
		}
		
		
		//여기까지 오면 일단 필요한 길이 이상의 덩어리들로 잘라두었다. 이제 여기서 sList를 돌면서 몇개 뽑을지만 보자.
		int result=0;
		
		for(int i=0;i<sList.size();i++) {
			
			int size=sList.get(i);
			
			result+=(size-N+1);
			
			
		}
		
		System.out.println(result);
		
	}
}
