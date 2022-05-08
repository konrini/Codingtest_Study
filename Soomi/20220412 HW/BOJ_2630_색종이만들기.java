import java.util.Scanner;

public class BOJ_2630_색종이만들기 {

	public static int paper[][], N, cntB, cntW;
	public static void main(String[] args) {
		//4등분해서 같은 색 될때까지 자르기
		Scanner sc = new Scanner(System.in);
		
		//한 변의 길이, 2,4,8,16,32,64,128
		N = sc.nextInt();
		paper = new int[N][N];
		//white:0, blue:1
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}//input
		
		cntB = cntW = 0;
		
		divide(0,0,N);
		
		System.out.println(cntW);
		System.out.println(cntB);
	}
	public static int check(int x, int y, int n) {
		
		int c = paper[x][y];
		
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(paper[i][j] != c) {
					return -1;
				}
			}
		}
		return c;
	}
	public static void divide(int x, int y, int n) {
		//검사해서 같은 색이면 cnt++
		if(check(x,y,n)==1) {
			cntB++;
			return;
		}
		if(check(x,y,n)==0) {
			cntW++;
			return;
		}
		
		divide(x, y, n/2);       //왼쪽 위부터 시계방향
		divide(x, y+n/2, n/2);
		divide(x+n/2, y, n/2);
		divide(x+n/2, y+n/2, n/2);
	}

}
