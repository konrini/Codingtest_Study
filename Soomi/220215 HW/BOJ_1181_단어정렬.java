import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1181_단어정렬 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String [] word = new String[N];
		
		//단어 입력
		for(int n=0;n<N;n++) {
			word[n] = sc.next();
		}
		
		Arrays.sort(word);
		Arrays.sort(word,new Comparator<String>() {
			//단어 길이로 정렬하도록 overriding
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});//overriding end
		
		System.out.println(word[0]);
		for(int i=1;i<N;i++) {
			if(!(word[i].equals(word[i-1]))) {
				System.out.println(word[i]);
			}
		}
	}

}
