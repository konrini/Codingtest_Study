package com.boj.day20220322;

import java.util.Scanner;

public class BOJ_2108_통계학 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int[] arr= new int[N];
		
		double sum=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
			
			if(max<arr[i] ) {
				max=arr[i];
			}
			
			if(min>arr[i]) {
				min=arr[i];
			}
			
			sum+=arr[i];
		}
		
		int[] result=new int[4];
		//1. 산술평균
		result[0]=(int) Math.round(sum/N);

		
		//4. 범위 
		result[3]=max-min;
		
		
		
		//아래 두개(중앙값,최빈값)는 정렬이 필요하다. 두 개를 한번에 처리할 만한 방법으로 counting 정렬을 하자!
		int[] count = new int[8001];
		
		//최빈값을 세기 위해서 필요한 값
		int maxCnt=Integer.MIN_VALUE;
		
		int cnt=1; //이건 최빈값에서 가장 많이 나오는 것이 한개인지, 두개 이상인지 확인. 두 가지 방식으로 최빈값 찾
		int max2=Integer.MIN_VALUE;  //한개일 경우, 바로 사
		for(int i=0;i<N;i++) {
			
			//-4000부터 4000까지 숫자가 가능하기 때문에, 0부터 시작하기 위해서 4000를 더해서 처리해준다!
			count[arr[i]+4000]++;
			
			if(maxCnt<count[arr[i]+4000]) {
				maxCnt=count[arr[i]+4000];
				max2=arr[i];
				cnt=1;
			
			//
			}else if(maxCnt==count[arr[i]+4000]) {
				cnt++;
			}
			
		}
		
		//3. 최빈값 
		//1개밖에 없으면  끝! 
		if(cnt==1) {
			result[2]=max2;
		//2개 이상이면, 작은거부터 돌리면서 두번째에 걸린거 출	
		}else {
			int c=1;
			//max2는 의미 없음
			for(int i=0;i<8001;i++) {
				
				if(count[i]==maxCnt) {
					
					if(c==2) {
						//count이므로, 원래 수는 4000만큼 빼줘야한다!(아까 0을 최소값으로 초기화했기 떄문)
						
						result[2]=i-4000;
					}
					c++;
				}
				
			}
			
			
		}
		

		
		
		//2. 중앙값
		//counting 정렬 특성상,count배열의 인덱스를 하나씩 합친다. 
		//그러면 바뀔 때의 인덱스가 중앙값이 될 인덱스를 넘는 순간, 그 인덱스가 바로 중앙값의 숫자(정확히는 4000을 뺀 숫자)가 된다.
		int idxSum=0;
		for(int i=0;i<8001;i++) {
			idxSum+=count[i];
			
			if(idxSum>=(N/2)+1) {
				result[1]=i-4000;
				break;
			}
			
		}
		
		
		for(int i : result) {
			System.out.println(i);
		}
		
		
		
		
	}
}