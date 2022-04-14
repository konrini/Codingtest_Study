import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, String[]> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 개수
        int N = Integer.parseInt(br.readLine());
        // key : 부모, value : 자식
        tree = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() + " ");
            String parent = st.nextToken();
            String[] child = { st.nextToken(), st.nextToken() };
            tree.put(parent, child);
        }
        VLR("A");
        System.out.println();
        LVR("A");
        System.out.println();
        LRV("A");

    }

    // 전위 순회 : 루 -> 왼 -> 오
    public static void VLR(String node) {
        System.out.print(node);
        if (!tree.get(node)[0].equals(".")) {
            VLR(tree.get(node)[0]);
        }
        if (!tree.get(node)[1].equals(".")) {
            VLR(tree.get(node)[1]);
        }
        return;
    }

    // 중위 순회 : 왼 -> 루 -> 오
    public static void LVR(String node) {
        if (!tree.get(node)[0].equals(".")) {
            LVR(tree.get(node)[0]);
        }
        System.out.print(node);
        if (!tree.get(node)[1].equals(".")) {
            LVR(tree.get(node)[1]);
        }
        return;
    }

    // 후위 순회 : 왼 -> 오 -> 루
    public static void LRV(String node) {
        if (!tree.get(node)[0].equals(".")) {
            LRV(tree.get(node)[0]);
        }
        if (!tree.get(node)[1].equals(".")) {
            LRV(tree.get(node)[1]);
        }
        System.out.print(node);
        return;
    }
}
