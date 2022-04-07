import java.util.Scanner;

public class BOJ_1991_트리순회 {
	
	public static char tree[][], root[];
	public static int N;
	public static StringBuilder sb;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		//node 개수, 1~26
		N = sc.nextInt();
		//[n][0]: 왼쪽, [n][1]: 오른쪽
		tree = new char[N][2];
		root = new char[N];
		for(int i=0; i<N; i++) {
			root[i] = (char)(65+i);
		}
		
		for(int i=0; i<N; i++) {
			int idx = (sc.next().charAt(0)-'0')-17;
			tree[idx][0] = sc.next().charAt(0);
			tree[idx][1] = sc.next().charAt(0);
		}
				
		PreOrder(0);
		sb.append("\n");
		InOrder(0);
		sb.append("\n");
		PostOrder(0);
		
		System.out.println(sb);
		
	}//end main
	
	public static void PreOrder(int idx) {
		
		if(idx>N) return;
		
		sb.append(root[idx]);
		if(tree[idx][0]!='.') PreOrder((tree[idx][0]-'0')-17);
		if(tree[idx][1]!='.') PreOrder((tree[idx][1]-'0')-17);
	}
	
	public static void InOrder(int idx) {
		
		if(idx>N) return;
		
		if(tree[idx][0]!='.') InOrder((tree[idx][0]-'0')-17);
		sb.append(root[idx]);
		if(tree[idx][1]!='.') InOrder((tree[idx][1]-'0')-17);
	}
	
	public static void PostOrder(int idx) {
		
		if(idx>N) return;
		
		if(tree[idx][0]!='.') PostOrder((tree[idx][0]-'0')-17);
		if(tree[idx][1]!='.') PostOrder((tree[idx][1]-'0')-17);
		sb.append(root[idx]);
	}

}
