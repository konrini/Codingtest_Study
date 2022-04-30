import java.util.Scanner;

public class BOJ_1927_최소힙_구현 {

	public static int heap[];
	public static void main(String[] args) {

		//x 넣기, 0: 가장 작은 값 출력/제거
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		heap = new int[1000000 +1];
		int size = 0;
		
		for(int i=0; i<N; i++) {
			
			int num = sc.nextInt();
			//0이면 작은 값 출력, 제거
			if(num ==0) {
				if(size==0)
					sb.append("0").append("\n");
				else {
					sb.append(heap[1]).append("\n");
					heap[1] = heap[size];
					size--;
					
					for(int j=1; j*2<=size;) {
						int left = j*2;
						int right = j*2 +1;
						
						if(heap[j]<heap[left] && heap[j]<heap[right]) {
							break;
						}
						
						if(heap[left]<heap[right]) {
							swap(j, left);
							j = left;
						}else {
							swap(j, right);
							j = right;
						}
						
					}
					
					
				}
			}//0 아니면 넣기
			else {
				heap[++size] = num;
				
				for(int j=size; j>1; j/=2) {
					if(heap[j]<heap[j/2]) {
						swap(j/2, j);
					}else
						break;
				}
			}
		}//end cal
		System.out.println(sb);
	}//main
	public static void swap(int p, int c) {
		int temp = heap[p];
		heap[p] = heap[c];
		heap[c] = temp;
	}
}
