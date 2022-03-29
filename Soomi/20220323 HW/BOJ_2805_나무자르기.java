import java.util.Scanner;

public class BOJ_2805_나무자르기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//나무 개수
		int N = sc.nextInt();
		//상근이한테 필요한 나무 길이
		int M = sc.nextInt();
		//잘린 나무 길이 더할 변수
		long sum =0;
		//나무 높이 저장할 배열
		int []tree = new int[N];
		
		int max =0;
		for (int i = 0; i < tree.length; i++) {
			int t = sc.nextInt();
			tree[i] = t;
			if(max<=t) {
				max = t;
			}
		}
		
		int min =0;
		int mid =0;

		while(min<max) {
			sum =0;
			mid=(min+max)/2;
			
			for (int i = 0; i < tree.length; i++) {
				if(tree[i]>mid) {
					sum += tree[i] - mid;
				}
				
			}
			if(sum<M) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		
		System.out.println(min-1);
		
	}

}
