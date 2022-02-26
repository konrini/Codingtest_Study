import java.util.Scanner;

public class BOJ_2567_색종이2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cp = sc.nextInt();
		int[][] bigpaper = new int[101][101];

		for (int i = 0; i < cp; i++) {  //색종이 수 만큼 각각의 색종이 1로 칠하기

			int a = sc.nextInt();
			int b = sc.nextInt();

			for (int x = a; x < a + 10; x++) {
				for (int y = b; y < b + 10; y++) {
					bigpaper[x][y] = 1;
				}
			}
		}//end for
		
		int cnt = 0;

		//둘레 길이 구하기
		for(int x=0;x<100;x++) {
			for(int y=0;y<100;y++) {
				if(bigpaper[x][y]==1) {
					if(x==0 || bigpaper[x-1][y]==0) {
						cnt++;
					}
					if(x==0 || bigpaper[x+1][y]==0) {
						cnt++;
					}
					if(y==0 || bigpaper[x][y-1]==0) {
						cnt++;
					}
					if(y==0 || bigpaper[x][y+1]==0) {
						cnt++;
					}
					
					
				}
			}
		}//둘레 길이 구하기 끝
		
		System.out.println(cnt);
		
	}
}