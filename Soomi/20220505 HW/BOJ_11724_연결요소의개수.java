import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {

	public static int p[], N;
	public static void main(String[] args) {
		//연결 요소 개수 구하기
		Scanner sc = new Scanner(System.in);
		
		//정점, 1~1000
		N = sc.nextInt();
		//간선, 0~N(N-1)/2
		int M = sc.nextInt();
		
		p = new int[N+1];
		
		//makeset
		for(int i=0; i<=N; i++)
			p[i] = i;
		
		for(int i=0; i<M; i++) {
			Union(sc.nextInt(), sc.nextInt());
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(p[i]==i)
				cnt++;
		}
		
		System.out.println(cnt);
	}//main
	public static int FindSet(int x) {
		if(x!=p[x])	return FindSet(p[x]);
		return x;
	}
	public static void Union(int x, int y) {
		p[FindSet(y)] = FindSet(x);
	}

}
