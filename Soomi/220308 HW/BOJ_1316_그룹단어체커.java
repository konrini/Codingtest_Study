import java.util.Scanner;

public class BOJ_1316_그룹단어체커 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//입력 들어올 단어 개수
		int N = sc.nextInt();
		//0으로 하고 더했더니 어려움
		int cnt =N;
		
		//N번 반복
		for (int n = 0; n < N; n++) {
			String s = sc.next();
			//알파벳 숫자만큼 배열 만들기, 기본값 false
			boolean [] check = new boolean[26];
			
			//s길이-1만큼 반복
			for (int i = 0; i < s.length()-1; i++) {
				//지금 글자
				char c = s.charAt(i);
				//다음 글자
				char next = s.charAt(i+1);
				
				//지금이랑 다음 글자가 다르면
				if(c!=next) {
					//배열에 이미 같은 단어가 있으면
					if(check[next-97]==true) {
						//그룹 단어 아님
						cnt--;
						break;
					}
				}
				//아니면 배열에서 true로 바꿔주기
				check[c-97] = true;
			}//for문 end
			
		}//N번 반복 end
		
		System.out.println(cnt);
	}

}
