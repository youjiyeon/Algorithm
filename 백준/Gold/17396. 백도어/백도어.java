import java.io.*;
import java.util.*;

public class Main
{
    public static class Node implements Comparable<Node>{
        int next;
        long val;

        public Node(int next, long val) {
            this.next = next;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if(this.val - o.val > 0) return 1;
            else return -1;
        }
    }
    public static int n;
    public static List<Node>[] list;
    public static long[] dist;
    public static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new long[n];
        visit = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int t =Integer.parseInt(st.nextToken());
            if (i!=n-1)
                visit[i] = t;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        System.out.println(dijkstra());
    }

    public static long dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0,0));
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (dist[cur.next] < cur.val){
                continue;
            }
            if (visit[cur.next]==1) continue;
            visit[cur.next]=1;
            
            for (Node nc: list[cur.next]) {
                if (visit[nc.next]==1) continue;
                if (dist[nc.next] > dist[cur.next]+ nc.val){
                    dist[nc.next] = dist[cur.next]+ nc.val;
                    q.offer(new Node(nc.next, dist[nc.next]));
                }
            }
        }

        dist[n-1] = dist[n-1] == Long.MAX_VALUE? -1 : dist[n-1];
        return dist[n-1];
    }
}