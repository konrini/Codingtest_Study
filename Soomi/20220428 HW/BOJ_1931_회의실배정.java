import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931_회의실배정 {

	public static void main(String[] args) {
		//최대 회의 개수
		
		Scanner sc = new Scanner(System.in);
		//회의 수, 1~100000
		int N = sc.nextInt();
		//[i][0]:시작, [i][1]:끝
		int meeting[][] = new int[N][2];
		
		//회의 정보, 시작 / 끝, 0~2^31-1
		for(int i=0; i<N; i++) {
			meeting[i][0] = sc.nextInt();
			meeting[i][1] = sc.nextInt();
		}
		
		//시작 시간으로 정렬, 끝나는 시간으로 정렬
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		//첫 번째 회의 하기
		int ans = 1;
		int end = meeting[0][1];  //끝나는 시간 저장
		
		for(int i=1; i<N; i++) {
			//끝난 시간보다 뒤에 시작하면
			if(meeting[i][0]>=end) {
				//끝나는 시간 갱신
				end = meeting[i][1];
				ans++;  //회의 한 번 더 함
			}
		}
		
		System.out.println(ans);
	}

}
