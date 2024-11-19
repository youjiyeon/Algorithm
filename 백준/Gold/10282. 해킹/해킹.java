import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int idx, time;
        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    static List<Node>[] list;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // start

            dp = new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            list = new List[n+1];
            for (int i = 1; i <= n; i++) {
                list[i] = new LinkedList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                list[from].add(new Node(to, time));
            }

            dijkstra(c);
            int cnt = 0;
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (dp[i]==Integer.MAX_VALUE) continue;
                max = Math.max(max, dp[i]);
                cnt++;
            }
            System.out.println(cnt+" "+max);
        }
    }

    static void dijkstra(int start) {
        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dp[cur.idx] < cur.time) continue;

            for (Node next : list[cur.idx]) {
                int nextDist = next.time+dp[cur.idx];
                if (dp[next.idx] > nextDist) {
                    dp[next.idx] = nextDist;
                    pq.offer(new Node(next.idx, nextDist));
                }
            }
        }
    }
}