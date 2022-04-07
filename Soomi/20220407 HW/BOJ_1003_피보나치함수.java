import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			//0~40
			int N = Integer.parseInt(br.readLine());
			
			int ZeroOne[][] = new int[N+2][2];
			
			ZeroOne[0][0] = 1; ZeroOne[0][1] = 0;
			ZeroOne[1][0] = 0; ZeroOne[1][1] = 1;
			
			for(int i=2; i<N+2; i++) {
				ZeroOne[i][0] = ZeroOne[i-1][0] + ZeroOne[i-2][0];
				ZeroOne[i][1] = ZeroOne[i-1][1] + ZeroOne[i-2][1];
			}
			
			sb.append(ZeroOne[N][0]).append(" ").append(ZeroOne[N][1]).append("\n");
		}
		System.out.println(sb);
	}

}
