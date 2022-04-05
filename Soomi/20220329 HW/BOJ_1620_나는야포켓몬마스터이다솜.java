import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//도감에 등록된 포켓몬 개수, 1~100000
		int N = sc.nextInt();
		//맞춰야 하는 문제 개수, 1~100000
		int M = sc.nextInt();
		
		//포켓몬 이름 저장할 map
		Map<String, Integer> nameString = new HashMap<String, Integer>();
		Map<Integer, String> nameInt = new HashMap<Integer, String>();

		//포켓몬 이름 입력
		for(int i=0;i<N;i++) {
			
			String s = sc.next();
			
			nameString.put(s, i+1);
			nameInt.put(i+1, s);
		}
		
		//문제 M개
		for(int i=0;i<M;i++) {
			String question = sc.next();
			boolean b = false;
			
			//숫자인지 문자인지 판별
			for(int j=0;j<question.length();j++) {
				if(question.charAt(j)>='0' && question.charAt(j)<='9') {
					b = true;
				}
			}
			
			//b==true면 숫자, 문자 출력
			if(b) {
				sb.append(nameInt.get(Integer.parseInt(question))).append("\n");
			}else {
				sb.append(nameString.get(question)).append("\n");
			}
			
			
		}
		
		System.out.println(sb);
		
	}

}
