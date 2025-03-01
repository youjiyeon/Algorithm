import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;
    static ArrayList<Integer>[] graph;
    static int cycleCount = 0; // 제거해야 하는 간선 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        graph = new ArrayList[n + 1]; // 제네릭 타입 명확하게 수정 ✅

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            graph[i] = new ArrayList<>(); // 각 리스트 초기화 ✅
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!union(a, b)) { // 사이클 발생 시
                cycleCount++;
            }
        }

        // 연결 요소 개수 세기
        int componentCount = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            int root = find(i);
            if (!visited[root]) {
                visited[root] = true;
                componentCount++;
            }
        }

        // 최소 연산 횟수 = 사이클 제거 횟수 + (연결 요소 - 1)
        int result = cycleCount + (componentCount - 1);
        System.out.println(result);
    }

    // 유니온-파인드: 루트 노드를 찾는 연산 (경로 압축 적용)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 유니온 연산 (사이클이 발생하면 false 반환)
    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false; // 사이클 발생

        if (x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
}
