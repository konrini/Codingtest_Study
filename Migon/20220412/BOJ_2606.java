import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static HashMap<Integer, List<Integer>> map; // 컴퓨터 연결
    static int cnt; // 1번을 통해 바이러스에 걸리게 되는 컴퓨터의 수
    static int[] visited; // 박문철이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 컴퓨터의 수
        int N = sc.nextInt();
        map = new HashMap<>();
        // 네트워크 상 연결 수
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int computer1 = sc.nextInt();
            int computer2 = sc.nextInt();
            if (map.containsKey(computer1)) {
                map.get(computer1).add(computer2);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(computer2);
                map.put(computer1, list);
            }
            if (map.containsKey(computer2)) {
                map.get(computer2).add(computer1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(computer1);
                map.put(computer2, list);
            }
        }
        // 박문철이
        visited = new int[N + 1];
        // BFS를 이용하여 연결되어 있는 컴퓨터 수 파악
        bfs(1);
        // 출력
        System.out.println(cnt);
    }

    static void bfs(int node) {
        // 1번 컴퓨터 박문철이
        visited[node] = 1;
        Queue<Integer> queue = new LinkedList<>();
        // 1번 컴퓨터에 연결되어 있는 컴퓨터 넣고 박문철이
        for (int c : map.get(node)) {
            queue.add(c);
            visited[c] = 1;
            cnt++;
        }
        while (!queue.isEmpty()) {
            int nc = queue.poll();
            // 새로 연결된 컴퓨터가 없을 때
            if (!map.containsKey(nc)) {
                continue;
            }
            // 컴퓨터에 연결되어 있으면서 아직 방문하지 않았을 때 추가
            for (int c : map.get(nc)) {
                if (visited[c] != 1) {
                    queue.add(c);
                    visited[c] = 1;
                    cnt++;
                }
            }
        }
    }
}