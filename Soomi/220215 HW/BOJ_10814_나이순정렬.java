import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10814_나이순정렬 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String member[][] = new String[N][2];
		
		//배열 입력
		for(int n=0;n<N;n++) {
			member[n][0]=sc.next();
			member[n][1] = sc.next();
		}
		
		Arrays.sort(member, new Comparator<String[]>() {
			//member 배열이 String이어서 [][0]번지만 parseint로 다시 comparator 정의
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
			}
			
		});
		
		for(int i=0;i<N;i++) {
			System.out.printf("%s %s\n",member[i][0],member[i][1]);
		}
		
		
	}

}
