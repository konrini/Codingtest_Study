package com.boj.day20220426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] cArr = br.readLine().toCharArray();
		
		//숫자들 저장용 queue 
		Queue<Integer> numQue = new LinkedList<>();
		//연산자 저장용 queue 
		Queue<String> operQue = new LinkedList<>();
		
		
		//여기서부터 숫자와 기호를 나눠서 queue에 각각 저장할 예정.
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<cArr.length;i++) {
			char c = cArr[i];
			//숫자인 경우. 숫자면 문자열로 만들어서 다닥다닥 붙여넣어주기 
			if(c>='0' && c<='9') {
				sb.append(c+"");
			
			//여기는 연산자. 그래서 연산자는 연산자 queue에 넣어주고, 지금까지 만들어진 sb는 숫자로 만들어서 숫자 queue에 톡 넣어준다.	
			}else {
				numQue.add(Integer.parseInt(sb.toString()));
				operQue.add(c+"");
				sb=new StringBuilder();  //다시 숫자 리셋 
			}
		}
		numQue.add(Integer.parseInt(sb.toString()));
		
		
		int result = numQue.poll(); //첫번째는 무조건 양수이기 때문에 뽑아두고 시작.
		
		int temp=0; //괄호처리용 값 임시 저장 
		boolean check=false; //현재 괄호처리중인지 확인용. false가 괄호가 안열린 상태(꺼져있는 상태)
		
		while(!operQue.isEmpty()) {
			
			String operator = operQue.poll();
			int num=numQue.poll();
			
			//아직 한번도 음수가 안나온 경우.
			if(!check) {
				//음수는 무조건 다 빼버리기
				if(operator.equals("-")) {
					check=true;
					result-=num;
				}
				//앞에가 전부 +면 그냥 무조건 더하기 
				else {
					result+=num;
				}
			}
			//한번이라도 -가 나온경우, 최소값을 만드는 것의 특성상 결국 다 빼는 형태로 묶어줄 수 있다. 결론적으로는 첫 마이너스 이후로는 그냥 다 뺴버리면 된다.
			else {
				result-=num;
			}
			
			
		}
		System.out.println(result);
		
		
	}
}