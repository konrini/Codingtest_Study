import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 첫 번째 숫자
		int first = sc.nextInt();
		// 최대 개수
		int max = 0;
		// 답
		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= first; i++) {
			List<Integer> numbers = new ArrayList<>();
			numbers.add(first);
			// 두 번째 숫자
			int second = i;
			numbers.add(second);
			while (true) {
				// 규칙대로 만든 새로운 숫자
				int next = numbers.get(numbers.size() - 2) - numbers.get(numbers.size() - 1);
				if (next >= 0) {
					numbers.add(next);
				} else {
					break;
				}
			}
			// 갱신
			if (numbers.size() > max) {
				max = numbers.size();
				answer = numbers;
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n");
		for (int num : answer) {
			sb.append(num).append(" ");
		}
		System.out.print(sb);
	}
}