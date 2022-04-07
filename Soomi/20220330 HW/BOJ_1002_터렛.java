import java.util.Scanner;

public class BOJ_1002_터렛 {

	public static int kyux, kyuy, seungx, seungy, kyuR, seungR;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//test case
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			
			//규현이 x좌표, y좌표, 재명이까지 거리
			kyux = sc.nextInt();
			kyuy = sc.nextInt();
			kyuR = sc.nextInt();
			
			//승환이 x좌표, y좌표, 재명이까지 거리
			seungx = sc.nextInt();
			seungy = sc.nextInt();
			seungR = sc.nextInt();
			
			double distance
				= Math.sqrt((kyux-seungx)*(kyux-seungx)
					+ (kyuy-seungy)*(kyuy-seungy));
						
			System.out.println(location(kyuR, seungR, distance));;
		}//end test case
	}//end main
	
	public static int location(int r1, int r2, double dis) {
		
		//두 반지름이 같고 원 중심이 같을 때 무한대로 겹침
		if(r1==r2 && kyux==seungx && kyuy==seungy ) {
			return -1;
		//한 점에서 만날 때, 원 밖에서 / 원 안에서
		}else if(r1+r2==dis || Math.abs(r1-r2)==dis) {
			return 1;
		//안 만날 때, 원 밖에서 안 만날때 / 원 안에서 안 만날 때 / 중심이 같은데 반지름이 다를때
		}else if(Math.abs(r2-r1)>dis || r1+r2<dis ||
				((kyux==seungx)&&(kyuy==seungy)&&(kyuR!=seungR))) {
			return 0;
		//나머지는 두 점에서 만남
		}else return 2;
		
	}

}
