import java.util.Scanner;

public class BOJ_13300_방배정 {

	public static void main(String[] args) {
		//같은 성별, 같은 학년 배정, 한 명 배정 가능

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();    //학생 수
		int k = sc.nextInt();    //배정 최대 인원 수
		int[][] std = new int[7][2];  //학년, 성별 저장 배열
		
		for(int n=1;n<=N;n++) {
			
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			
			if(gender==0) {
				std[grade][0]++;
			}else {
				std[grade][1]++;
			}
			
		}//입력 끝
		
		int cnt =0;
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<2;j++) {
				if(std[i][j] !=0) {
					if(std[i][j] %k ==0) {
						cnt += std[i][j] /k;
					}else
						cnt += std[i][j]/k +1;
				}else
					continue;
			}
		}
		
		System.out.println(cnt);
	}

}
