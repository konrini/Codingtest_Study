import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11723_집합 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 수행해야 하는 연산의 수
		int M = sc.nextInt();

		// 비어있는 공집합 S, 해당 숫자 있으면 true, 없으면 false 표시
		boolean[] arr = new boolean[20];

		for (int i = 0; i < M; i++) {

			String s = sc.next();

			//all/ empty가 아니면 다음에 숫자 x가 입력됨
				switch (s) {
				// 집합에 x 추가, 이미 있으면 무시
				case "add":
					arr[sc.nextInt()-1] = true;
					break;
				// 집합에서 x 제거, 없으면 무시
				case "remove":
					arr[sc.nextInt()-1] = false;
					break;
				// x가 있으면 1, 없으면 0 반환
				case "check":
					if(arr[sc.nextInt()-1]==false) {
						sb.append("0\n");
					}else {
						sb.append("1\n");
					}
					break;
				// x가 있으면 제거, 없으면 추가
				case "toggle":
					int num = sc.nextInt()-1;
					if(arr[num]==true) {
						arr[num]=false;
					}else {
						arr[num]=true;
					}
					break;
				case "all":
					//전부 true
					Arrays.fill(arr, true);
					break;
				case "empty":
					//전부 false
					Arrays.fill(arr, false);
					break;
				}// end switch
		} // end for
		
		System.out.println(sb);

	}// end main

}
