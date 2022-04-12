import java.util.Scanner;

public class BOJ_2606_바이러스 {

	public static int p[];
	public static void main(String[] args) {
		//같이 바이러스 걸리는 컴퓨터 수 출력
		Scanner sc = new Scanner(System.in);
		//computer, 1~100
		int N = sc.nextInt();
		//connect
		int C = sc.nextInt();
		
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		for(int i=0; i<C; i++) {
			Union(sc.nextInt(),sc.nextInt());
		}
		int cnt = 0;
		for(int i=2; i<=N; i++) {
			if(FindSet(i)==FindSet(1)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static int FindSet(int x) {
		if(x!=p[x])	return p[x]=FindSet(p[x]);
		return x;
	}
	public static void Union(int x, int y) {
		p[FindSet(y)] = FindSet(x);
	}

}
