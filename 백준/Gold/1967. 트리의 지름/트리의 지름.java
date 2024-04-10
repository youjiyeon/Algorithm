import java.io.*;
import java.util.*;
public class Main {
    public static class Node{
        int idx,cnt;
        Node (int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    public static int n, max = 0, maxIdx = 0;
    public static boolean[] v;
    public static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        v = new boolean[n+1];
        list = new List[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        v[1] = true;
        dfs(1, 0);

        v = new boolean[n+1];
        v[maxIdx] = true;
        dfs(maxIdx, 0);
        
        System.out.println(max);
    }

    public static void dfs(int idx, int cnt) {
        if (max < cnt) {
            max = cnt;
            maxIdx = idx;
        }

        for (Node a : list[idx]) {
            if (!v[a.idx]) {
                v[a.idx] = true;
                dfs(a.idx, cnt+a.cnt);
            }
        }
    }
}