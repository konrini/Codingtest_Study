import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2751_수정렬하기2 {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> al = new ArrayList<>();
		
		int N = sc.nextInt();
		
		//배열 입력
		for(int i=0;i<N;i++) {
			al.add(sc.nextInt());
		}
		
		java.util.Collections.sort(al);
		
		for(int i :al) {
			sb.append(i);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
