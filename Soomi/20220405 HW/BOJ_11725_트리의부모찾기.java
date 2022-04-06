import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11725_트리의부모찾기 {

	public static int N;
	public static boolean[] check;
	public static int[] parents;
	public static ArrayList<Integer>[] num;
	public static void main(String[] args) {

		//트리 루트를 1이라고 가정, 노드 부모 구하기
		Scanner sc = new Scanner(System.in);
		
		//node 수
		N = sc.nextInt();
		num = new ArrayList[N+1];   //어떻게 쓰는거야ㅠㅠ
		parents = new int[N+1];
		check = new boolean[N+1];
		
		for(int i=1;i<N+1;i++) {
			num[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			num[first].add(second);
			num[second].add(first);
		}
		
		dfs(1);
		
		for(int i=2;i<N+1;i++) {
			System.out.println(parents[i]);
		}
		
	}//end main
	
	public static void dfs(int idx) {
		//이미 봤으면 return
		if(check[idx]) {
			return;
		}
		//봄
		check[idx] = true;
		
		for(int x: num[idx]) {
			if(!check[x]) {   //안봤으면 부모 = idx
				parents[x] = idx;
				dfs(x);       //재귀
			}
		}
		
	}

}
