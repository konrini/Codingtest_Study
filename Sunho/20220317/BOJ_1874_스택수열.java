package com.boj.day20220317;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		int N = sc.nextInt();
		
		
		//입력값 받을 배열 
		int[] arr= new int[N+1];
		//최대값(N)이 들어올 때의 인덱스 가져오기. 왜냐하면 최대값이 들어온다는 것은 이제 push가 다 끝났기 때문!! 
		//그래서 그 이후 부분은 무조건 내림차순이어야 한다
		
		int maxIdx=-1;
		
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
			if(arr[i]==N) {
				maxIdx=i;
			}
			
			//최대값 들어온 이후, 그 뒤에는 무조건 내림차순이어야한다! 그래서 한번에 확인해주기!
			if(maxIdx>=0 && maxIdx<i) {
				
				if(arr[i-1]<arr[i]) {
					System.out.println("NO");
					return;
				}
				
				
			}
			
		}
		
		Stack<Integer> stack = new Stack<>();
		int idx=1;
		int cnt=1;
		
		StringBuilder sb = new StringBuilder();
		
		/*위에서 maxIdx 뒷부분이 되는지 안되는지를 체크했다. 
		 * 그래서 앞부분을 체크하러 가자. 
		 * 오름차순(1부터 들어갈 숫자 )는 cnt로 해서 하나씩 늘린다.
		 * 그래서 idx번째 arr의 숫자와 비교해서 넣을지 뺄지를 체크해본다!
		 * 
		 * */
		while(cnt<=N) {
			
			//수열보다 cnt가 작으면, 아직 더 키워야한다! 즉, 계속 넣어주
			if(cnt<arr[idx]) {
				stack.add(cnt);
				sb.append("+\n");
				cnt++;
			
			//더 작은 경우, 이는 빼내는 경우밖에 없다. 그래서 stack의 맨 위를 보고 그게 arr[idx]와 같은 경우, 뽑아낸다. 다르면 끝!
			}else if(cnt>arr[idx]) {
				
				
				
				int num=stack.pop();
				
				if(num==arr[idx]) {
					sb.append("-\n");
					idx++;
				}else {
					System.out.println("NO");
					return;
				}
				
				
				
			
			//같은 경우, 넣고 바로 빼버리면 된다.그래서 stack자체에는 변화가 없다.	cnt는 당연히 올려주고, idx도 처리해서 하나 올려준다.
			}else {
				sb.append("+\n");
				sb.append("-\n");
				cnt++;
				idx++;
			}
			
			
		}
		
		//여기까지 온것은 앞부분끝났고, 뒷부분은 문제가 없기 때문에 마지막 부분 처리만 해주자
		while(!stack.isEmpty()) {
			stack.pop();
			sb.append("-\n");
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}
}