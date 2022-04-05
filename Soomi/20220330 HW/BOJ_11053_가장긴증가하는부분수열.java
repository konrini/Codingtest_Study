import java.util.Scanner;

public class BOJ_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//수열 A의 크기, 1~1000
		int N = sc.nextInt();
		
		int[]A = new int[N];
		
		//수열 입력
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		//첫번째 원소부터 start로 등록, start보다 크면 count++
		//Ex) 10 20 30 50 40 42 45 47 70
		//10-20-30-50-70으로 세면 틀림
		
		int cnt = 0;
		//i까지 돌면서 더 작은 것만 다 더해서 저장
		int []temp = new int[N];
		for(int i=0;i<N;i++) {
			
			int asc = 0;
			
			for(int j=0;j<i;j++) {
				if(A[i] > A[j]) {//더 작으면
					//최대값 갱신
					asc = Math.max(asc,temp[j]);
				}
			}
			//갱신한 최대값 더해주기(본인 포함 +1)
			temp[i] = asc+1;
			
			//최대값 찾아두기
			cnt = Math.max(temp[i], cnt);
		}
		
		System.out.println(cnt);
	}

}
