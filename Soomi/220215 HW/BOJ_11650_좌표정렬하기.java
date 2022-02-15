import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11650_좌표정렬하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] loca = new int[N][2];
		
		//좌표 입력
		for(int n=0;n<N;n++) {
			loca[n][0]=sc.nextInt();
			loca[n][1] = sc.nextInt();
		}
		
		//comparator 정의
		Arrays.sort(loca, (o1,o2) ->{
			if(o1[0]==o2[0]) {    //0번지 같으면 1번지 비교
				return Integer.compare(o1[1], o2[1]);
			}else {				 //0번지 다르면 0번지 비교
				return Integer.compare(o1[0], o2[0]);
			}
		});//end of comparator
		
		
		//출력
		for(int i=0;i<N;i++) {
			System.out.println(loca[i][0]+" "+loca[i][1]);
		}
		
	}

}
