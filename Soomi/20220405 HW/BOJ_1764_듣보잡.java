import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1764_듣보잡 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//듣도 못한 사람 수
		int N = sc.nextInt();
		//보도 못한 사람 수
		int M = sc.nextInt();
		
		//겹치는 사람 수
		int cnt =0;
		
		HashMap<String, Integer> name = new HashMap<>();
		String []ans = new String[N+M];
		
		for(int i=0;i<N+M;i++) {
			String s = sc.next();
			//이미 hashmap에 이름이 있으면 ans 배열에 넣고 cnt++
			if(name.containsKey(s)) {
				ans[cnt] = s;
				cnt++;
			}
			//hashmap에 이름 추가
			name.put(s, i);
		}
		//cnt길이만큼 잘라서 알파벳 순 정렬(null값 있으면 정렬 안됨)
		String[] arr = Arrays.copyOfRange(ans, 0, cnt);
		Arrays.sort(arr);
		
		System.out.println(cnt);
		for(int i=0;i<cnt;i++) {
			System.out.println(arr[i]);
		}
		
	}

}
