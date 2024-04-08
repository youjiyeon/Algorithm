import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] color;
    public static int[] prev;
    public static int[] target;
    public static boolean[] v;
    public static List<Integer>[] tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        color = new int[N + 1];
        prev = new int[N + 1];
        target = new int[N + 1];
        
        v = new boolean[N + 1];
        tree = new List[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            tree[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        System.out.print(bfs());
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        queue.add(1);
        v[1] = true;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            if (color[parent] != target[parent]) {
                color[parent] = target[parent];
                prev[parent] = color[parent];
                cnt++;
            }

            for(int child : tree[parent]) {
                if (v[child]) continue;
                
                v[child] = true;

                color[child] = prev[parent];
                prev[child] = color[child];
                queue.add(child);
            }
        }

        return cnt;
    }
}