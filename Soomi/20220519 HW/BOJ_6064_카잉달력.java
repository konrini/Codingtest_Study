import java.util.Scanner;

public class BOJ_6064_카잉달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//test case T
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			// 1~40000
			int M = sc.nextInt();
			int N = sc.nextInt();
			// 1~M
			int x = sc.nextInt();
			// 1~N
			int y = sc.nextInt();
			
            int least = LCM(N,M);
            
           for(int ans = x; ; ans +=M) {
        	   if(ans > least){
                    sb.append("-1").append("\n");
                    break;
                }else if(ans%N==0) {
                	if(N==y) {
                		sb.append(ans).append("\n");
                        break;
                	}
                }else if(ans%N ==y) {
                	sb.append(ans).append("\n");
                    break;
                }
           }
			
		}//test case
		System.out.println(sb);
	}// main
	// 최대공약수 구하기
	public static int GCD(int x, int y) {
		if(y==0) return x;
		
		return GCD(y, x%y);
	}
	// 최소공배수 구하기
	public static int LCM(int x, int y) {
		return x * y / GCD(x,y);
	}
}
