import java.util.Scanner;

public class BOJ_10866_덱 {

	public static int[] Deque;
	public static int rear = -1;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		Deque = new int[N];
		
		for (int order = 0; order < N; order++) {

			String s = sc.next();
			
			switch (s) {
			case "push_front":
				push_front(sc.nextInt());
				break;
			case "push_back":
				push_back(sc.nextInt());
				break;
			case "pop_front":
				sb.append(pop_front()).append("\n");
				break;
			case "pop_back":
				sb.append(pop_back()).append("\n");
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
	public static void push_front(int num) {
		rear++;
		
		for (int i = rear; i > 0 ; i--) {
			Deque[i] = Deque[i-1];
		}
		Deque[0] = num;
	}
	
	public static void push_back(int num) {
		rear++;
		Deque[rear] =num;
	}
	
	public static int pop_front() {
		int ans = Deque[0];
		
		if(rear==-1) {
			return -1;
		}
		for (int i = 0; i < rear; i++) {
			Deque[i] = Deque[i+1];
		}
		rear--;
		return ans;
	}
	
	public static int pop_back() {
		
		if(rear==-1) {
			return -1;
		}else {
			int ans = Deque[rear];
			rear--;
			return ans;
		}
		
	}
	
	public static int size() {
		if(rear==-1) {
			return 0;
		}else {
			return rear+1;
		}
	}
	
	//none:1 or 0
	public static int empty() {
		if(rear==-1) {
			return 1;
		}else
			return 0;
	}
	
	public static int front() {
		if(rear==-1) {
			return -1;
		}else {
			return Deque[0];
		}
	}
	
	public static int back() {
		if(rear==-1) {
			return -1;
		}else
			return Deque[rear];
	}
}
