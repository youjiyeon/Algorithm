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
    public static int[] dist;
    public static int[] way;
    public static List<Node>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        lists = new List[n+1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        dist = new int[n+1];
        way = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(s, e));

        ArrayList<Integer> routes = new ArrayList<>();
        int current = e;
        while(current != 0) {
            routes.add(current);
            current = way[current];
        }
        System.out.println(routes.size());
        for(int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    private static int dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        pq.offer(new Node(s, 0));
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        way[s] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (dist[cur.n]< cur.d)
                continue;

            for (Node next:lists[cur.n]) {
                if(dist[next.n]>cur.d+next.d){
                    way[next.n] = cur.n;
                    dist[next.n]=cur.d+next.d;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist[e];
    }
}