import java.util.Scanner;

public class BOJ_2563_색종이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cp = sc.nextInt();
		int cnt=0;
		int[][] bigpaper = new int[100][100];
		
		
		for(int i=0;i<cp;i++) {
	
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int x =a;x<a+10;x++) {
				for(int y=b;y<b+10;y++) {					
					bigpaper[x][y] = 1;
				}
			}
			
		}
		for(int x=0;x<100;x++) {
			for(int y=0;y<100;y++) {
				if(bigpaper[x][y]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
