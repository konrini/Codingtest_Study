import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	// 아홉 난쟁이의 키
	static int[] height = new int[9];
	// 일곱 난쟁이의 키
	static List<Integer> seven;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 아홉 난쟁이의 키 받아오기
		for (int i = 0; i < height.length; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		findseven(0, 0, new ArrayList<>());
		// 오름차순 정렬
		Collections.sort(seven);
		for (int h : seven) {
			System.out.println(h);
		}
	}

	public static void findseven(int idx, int sum, List<Integer> list) {
		if (idx == 9 && list.size() == 7) {
			if (sum == 100) {
				// 딥카피
				seven = new ArrayList<>(list);
				return;
			}
			return;
		} else if (idx == 9) {
			return;
		}
		// 현재 키 넣기
		list.add(height[idx]);
		findseven(idx + 1, sum + height[idx], list);
		// 현재 키 안 넣기
		list.remove(list.size() - 1);
		findseven(idx + 1, sum, list);
	}
}
