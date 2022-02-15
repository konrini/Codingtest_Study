import java.util.Scanner;

public class BOJ_7568_덩치 {

	public static void main(String[] args) {
		//몸무게 x, 키 y
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int human[][] = new int[N][2];
		
		//0번지 몸무게, 1번지 키 입력
		for(int n=0;n<N;n++) {
			human[n][0]=sc.nextInt();
			human[n][1] = sc.nextInt();
		}
		
		//본인보다 큰 사람 있으면 size++
		for(int i=0;i<N;i++) {
			int size=1;     //초기화
			for(int j=0;j<N;j++) {
				if(i!=j && human[i][0]<human[j][0] && human[i][1]<human[j][1]) {
					size++;
				}
			}
			
			System.out.printf("%d ",size);
		}//size for문 end
		
		
	}

}
