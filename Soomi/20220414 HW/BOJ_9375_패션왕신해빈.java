import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_9375_패션왕신해빈 {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			
			HashMap<String, Integer> closet = new HashMap<>();
			
			//의상 수
			int n = sc.nextInt();
			for(int i=0; i<n; i++) {
				sc.next(); //같은 이름 없음, 버려도 됨
				String category = sc.next();
				
				if(!closet.containsKey(category))
					closet.put(category, 1);
				else
					closet.put(category, closet.get(category)+1);
			}
			//종류가 N개면, N가지 방법 +1(안 입을 수도 있음)
			int ans =1;
			for(int x : closet.values()) {
				ans *= (x+1);
			}
			//알몸인 경우 --
			System.out.println(ans-1);
		}//test case
	}//main

}
