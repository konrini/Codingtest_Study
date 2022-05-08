package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_1991 {
	static HashMap<String, Integer> treeMap;
	static HashMap<Integer, String> tree;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		treeMap = new HashMap<>();
		tree = new HashMap<>();


		treeMap.put("A", 1);
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			int parent = treeMap.get(tmp[0]);
			if (!tmp[1].equals(".")) {
				treeMap.put(tmp[1], parent * 2);
			}
			if (!tmp[2].equals(".")) {
				treeMap.put(tmp[2], parent * 2 + 1);
			}
		}
		for(String key : treeMap.keySet()) {
			tree.put(treeMap.get(key), key);
		}

		// 전위
		sb = new StringBuilder();
		pre(treeMap.get("A"));
		System.out.println(sb);
		// 중위
		sb.setLength(0);
		in(treeMap.get("A"));
		System.out.println(sb);
		// 후위
		sb.setLength(0);
		post(treeMap.get("A"));
		System.out.println(sb);
	}// main

	static void pre(int n) {
		if (tree.containsKey(n)) {
			sb.append(tree.get(n));
			pre(n * 2);
			pre(n * 2 + 1);
		}
		
	}

	static void in(int n) {
		if (tree.containsKey(n)) {
			in(n * 2);
			sb.append(tree.get(n));
			in(n * 2 + 1);
		}
	}

	static void post(int n) {
		if (tree.containsKey(n)) {
			post(n * 2);
			post(n * 2 + 1);
			sb.append(tree.get(n));
		}
	}
}
