import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10989_수정렬하기3 {

	public static void main(String[] args)  throws IOException{
		
		//scanner 시간초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] num = new int[N];
		
		//숫자 배열 입력
		for(int n=0;n<N;n++) {
			num[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);  //오름차순 정렬
		
		for(int i=0;i<N;i++) {
			sb.append(num[i]);
			sb.append('\n');
		}
		
		System.out.print(sb);
	}

}
