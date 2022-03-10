import java.util.Scanner;

public class BOJ_10845_큐 {

	public static int[] Queue;
	public static int front =0;
	public static int back =-1;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
				
		int N = sc.nextInt();
		Queue = new int[N]; 

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
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
			
		}//end for
		
		System.out.println(sb);
		sc.close();
	}//end main
	
	//push, pop, size, empty, front, back
	public static void push(int num) {
		Queue[++back] = num;
	}
	
	//none:-1
	public static int pop() {
		if(size()==0) {
			return -1;
		}else
			return Queue[front++];
	}
	
	public static int size() {
		return back - front +1;
	}
	
	//none:1 or 0
	public static int empty() {
		if(size()==0) {
			return 1;
		}else
			return 0;
	}
	
	//none:-1
	public static int front() {
		if(size()==0) {
			return -1;
		}else
			return Queue[front];
	}
	
	//none:-1
	public static int back() {
		if(size()==0) {
			return -1;
		}else
			return Queue[back];
	}

}
