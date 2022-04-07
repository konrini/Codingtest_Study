import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Integer, List<Integer>> map;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 노드의 개수
        int N = Integer.parseInt(br.readLine());
        // key = 노드 번호, value = 노드와 연결되어 있는 노드 리스트
        map = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (map.keySet().contains(num1)) {
                map.get(num1).add(num2);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(num2);
                map.put(num1, list);
            }
            if (map.keySet().contains(num2)) {
                map.get(num2).add(num1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(num1);
                map.put(num2, list);
            }
        }
        // 부모의 정보를 담은 배열
        tree = new int[N + 1];
        // 1번 노드부터 시작
        DFS(1);
        // 출력
        for (int i = 2; i < tree.length; i++) {
            bw.write(tree[i] + "\n");
        }
        br.close();
        bw.close();
    }

    public static void DFS(int parent) {
        // 연결되어 있는 노드를 모두 가져옴.
        List<Integer> relation = map.get(parent);
        for (int node : relation) {
            // 부모 노드 빼고
            if (node == tree[parent]) {
                continue;
            }
            tree[node] = parent;
            DFS(node);
        }
    }
}
