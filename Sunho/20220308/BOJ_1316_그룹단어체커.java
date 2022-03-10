package com.boj.day20220308;

import java.util.Scanner;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int t=sc.nextInt();
		
		//전체 그룹단어 개수
		int cnt = 0;
		
		for(int idx=0;idx<t;idx++) {
			
			//알파벳이 연속으로 나오는지를 받아주기!
			int[] alpha=new int[26];
			
			String str = sc.next().toLowerCase();
			
			
			char c = str.charAt(0);
			
			//알파벳이 연속되는지를 항상 확인할것. 그래서 c
			alpha[c-'a']++;
			
			boolean check=true;
			for(int i=1;i<str.length();i++) {
				

				//알파벳 하나씩 떼보기 
				char al=str.charAt(i);
				//같은 알파벳이 연속중이기 때문에 다음거로!
				if(al==c) {
					
					continue;
				}
				//연속하지 않으면 확인해주어야 한다!
				else {
					
					//아직 이 알파벳이 한번도 세어지지 않았다. 즉, 그룹단어가 깨지지 않았다!
					if(alpha[al-'a']==0) {
						alpha[al-'a']++;
						
						//바깥의 c를 새로운 알파벳으로 갱신해주어 뒷부분을 또 보러 간다.
						c=al;
					//아까 썼던 알파벳이 또 들어왔다!! 즉, 그룹단어가 아니다!	
					}else if(alpha[al-'a']==1) {
						check=false;
						
						break;
					}
					
					
				}
				
				
				
			}
			
			if(check) {
				cnt++;
			}
			
			
			
		}
		
		System.out.println(cnt);
		
		
	}
}

