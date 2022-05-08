import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1541_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//세준이는 양수, +, -, 괄호로 식을 만들고 괄호 모두 지움....왜?
		//최소 식 값 출력하려면 -뒤에 있는거 다 빼야 함
		String arr[] = sc.next().split("-");
		
		int ans = 0;

		for(int i=0; i<arr.length; i++) {
			int sum = 0;
			//patternsyntaxexception 없애려면 \\
			String arrsum[] = arr[i].split("\\+");
			
			for(int j=0; j<arrsum.length; j++) {
				sum += Integer.parseInt(arrsum[j]);
			}
			
			//arr[0]에서 나머지 다 빼기
			if(i==0) {
				ans += sum;
			}else {
				ans -= sum;
			}
		}
		
		System.out.println(ans);
		
	}

}
