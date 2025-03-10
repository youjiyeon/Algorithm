import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dist;
    static class Node {
        int n;
        int d;
        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken())-1;
        int e = Integer.parseInt(st.nextToken())-1;
        System.out.println(dijkstra(s, e));
    }

    static int dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.d-o2.d);
        pq.offer(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.n] < cur.d) continue;

            for (Node next: list[cur.n]) {
                if (dist[next.n] > dist[cur.n]+next.d) {
                    dist[next.n] = dist[cur.n]+next.d;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }

        return dist[e];
    }
}