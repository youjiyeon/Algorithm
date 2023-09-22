import java.io.*;
import java.util.*;

public class Main
{
    public static class Node{
        int n;
        int d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
    public static int n;
    public static List<Node>[] graph;
    public static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        dist = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }
        
        System.out.println(dijstra(1, n));

    }

    private static int dijstra(int s, int e) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.d-o2.d);
        q.offer(new Node(s,0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while (!q.isEmpty()){
            Node cur = q.poll();

            for (Node n: graph[cur.n]) {
                if (dist[n.n]>dist[cur.n]+n.d){
                    q.offer(n);
                    dist[n.n]=dist[cur.n]+n.d;
                }
            }
        }

        return dist[e];
    }
}