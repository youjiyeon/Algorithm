import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] dist;
    static class Node implements Comparable<Node>{
        int n;
        long d;
        public Node(int n, long d) {
            this.n = n;
            this.d = d;
        }
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }
    static List<Node>[] list;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dist = new long[n+1];
        list = new List[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[b].add(new Node(a, c));
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int s = Integer.parseInt(st.nextToken());

            dist[s] = 0;
            pq.offer(new Node(s, 0));

        }
        dijkstra();

        long max = 0;
        int maxIdx = -1;
        for (int i = 1; i <= n; i++) {
            if (max < dist[i]) {
                max = dist[i];
                maxIdx = i;
            }
        }
        System.out.println(maxIdx);
        System.out.println(max);
    }

    static void dijkstra() {
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.n] < cur.d) continue;

            for (Node next: list[cur.n]) {
                if (dist[next.n] > cur.d+next.d) {
                    dist[next.n] = cur.d+next.d;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
    }
}