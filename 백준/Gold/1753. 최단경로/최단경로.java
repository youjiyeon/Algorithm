import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int n;
        int w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }

    static List<Node>[] list;
    static boolean[] v;
    static int V;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());

        list = new List[V+1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        v = new boolean[V+1];
        dp = new int[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,w));
        }

        bfs(s);
        for (int i = 1; i <= V; i++) {
            sb.append(dp[i] == Integer.MAX_VALUE ? "INF" : dp[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int s) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
        q.offer(new Node(s,0));
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[s] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.w > dp[cur.n]) continue;

            for (Node next:list[cur.n]) {
                if (dp[next.n] > dp[cur.n]+next.w) {
                    dp[next.n] = dp[cur.n]+next.w;
                    q.offer(new Node(next.n, dp[next.n]));
                }
            }
        }
    }
}