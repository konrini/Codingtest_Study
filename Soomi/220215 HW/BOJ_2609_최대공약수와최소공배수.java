import java.util.Scanner;

public class BOJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int b = Math.max(A, B);
		int s = Math.min(A, B);
		
		int gcd=0;
		int lcm=0;
		
		//최소공배수
		for(int i=b;;i++) {
			if(i%b==0 && i%s==0) {
				lcm=i;
				break;
			}
		}//최소공배수 for문 end
		
		//최대공약수
		for(int i=1;i<=s;i++) {
			if(b%i==0 && s%i==0) {
				gcd=i;
			}
		}//최대공약수 for문 end
		
		System.out.println(gcd);
		System.out.println(lcm);
	}

}
