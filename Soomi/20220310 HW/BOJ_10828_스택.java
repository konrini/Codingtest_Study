import java.util.Scanner;

public class BOJ_10828_스택 {
	
	public static int top = -1;
	public static int[] Stackarr;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		
		int N = sc.nextInt();
		Stackarr = new int[N];
		
		for (int order = 0; order < N; order++) {
			
			String s = sc.next();
			
			switch (s) {
			case "push":
				push(sc.nextInt());
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "top":
				sb.append(top()).append("\n");
				break;
			}
			
		}//end for

		System.out.println(sb);
		sc.close();
		
	}//end main
	
	//push, pop, size, empty, top
	public static void push(int num) {
		top++;
		Stackarr[top] = num;
	}
	
	//없으면 -1
	public static int pop() {
		if(top==-1) {
			return -1;
		}else {
			int ans = Stackarr[top];
			
			Stackarr[top] =0;
			top--;
			
			return ans;
		}
	}
	
	public static int size() {
		return top+1;
	}
	
	//비었으면 1, 아니면 0
	public static int empty() {
		if(top==-1) {
			return 1;
		}else
			return 0;
	}
	
	//비었으면 -1
	public static int top() {
		if(top==-1) {
			return -1;
		}else
			return Stackarr[top];
	}

}
