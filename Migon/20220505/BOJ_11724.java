import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] p;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        int V = Integer.parseInt(st.nextToken()); // 정점의 수
        int E = Integer.parseInt(st.nextToken()); // 간선의 수
        int[][] edges = new int[E][2]; // 연결 관계
        for (int i = 0; i < E; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine() + " ");
            edges[i][0] = Integer.parseInt(st1.nextToken());
            edges[i][1] = Integer.parseInt(st1.nextToken());
        }
        // 상호 배타적 집합
        p = new int[V + 1];
        // Rank
        rank = new int[V + 1];

        // 새로운 집합 생성
        for (int i = 1; i <= V; i++) {
            Make_Set(i);
        }

        // 연결하기
        for (int i = 0; i < E; i++) {
            if (Find_Set(edges[i][0]) != Find_Set(edges[i][1])) {
                Union(edges[i][0], edges[i][1]);
            }
        }

        // 이제 리더들끼리는 다 묶였으니 다시 쫄병들도 묶어주기
        for (int i = 0; i < E; i++) {
            if (Find_Set(edges[i][0]) != Find_Set(edges[i][1])) {
                Union(edges[i][0], edges[i][1]);
            }
        }

        // 무리 개수 세기
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < V + 1; i++) {
            set.add(p[i]);
        }

        // 출력
        bw.write(set.size() + "");
        bw.close();
    }

    public static void Make_Set(int x) {
        p[x] = x;
        rank[x] = 0;
    }

    public static void Link(int x, int y) {
        if (rank[x] > rank[y]) {
            p[y] = x;
        } else {
            p[x] = y;
            if (rank[x] == rank[y]) {
                rank[y]++;
            }
        }
    }

    public static void Union(int x, int y) {
        Link(Find_Set(x), Find_Set(y));
    }

    public static int Find_Set(int x) {
        if (x != p[x]) {
            p[x] = Find_Set(p[x]);
        }
        return p[x];
    }
}