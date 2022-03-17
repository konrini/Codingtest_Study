import java.util.Scanner;

public class BOJ_2941_크로아티아알파벳 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		String Croatia[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
				
		for (int i = 0; i < Croatia.length; i++) {
			if(s.contains(Croatia[i])) {
				//croatia 알파벳 포함하면 C로 치환, 소문자만 들어오니까 대문자로
				s = s.replace(Croatia[i], "C");
			}
			
		}//end for
		
		System.out.println(s.length());
	}//end main

}
