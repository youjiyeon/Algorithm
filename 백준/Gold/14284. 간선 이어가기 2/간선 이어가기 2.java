import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m, s, e;
    public static int[] dist;
    public static class Node{
        int idx;
        int val;

        public Node(int next, int val) {
            this.idx = next;
            this.val = val;
        }
    }
    public static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        dist = new int[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,v));
            list[to].add(new Node(from,v));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        q.offer(new Node(s,0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.val>dist[cur.idx])
                continue;

            for (Node n: list[cur.idx]) {
                if(dist[n.idx]>n.val+dist[cur.idx]){
                    dist[n.idx]=n.val+dist[cur.idx];
                    q.offer(new Node(n.idx, dist[n.idx]));
                }
            }
        }
        return dist[e];
    }
}