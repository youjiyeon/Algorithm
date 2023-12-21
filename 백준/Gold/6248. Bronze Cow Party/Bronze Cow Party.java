import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int n;
        int l;

        public Node(int n, int l) {
            this.n = n;
            this.l = l;
        }
    }

    // n: 지역 수, m: 간선수, x: 시작점
    public static int n, m, x;
    // 각 지역별 아이템 수 저장
    public static int[] dist;
    public static List<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            list[to].add(new Node(from, len));
            list[from].add(new Node(to, len));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i!=x){
                max = Math.max(max, dijkstra(i));
            }
        }
        System.out.println(2*max);
    }
    public static int dijkstra(int e){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2)->o1.l-o2.l);
        q.offer(new Node(x, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (dist[cur.n]<cur.l)
                continue;
            for (Node next: list[cur.n]) {
                if (dist[next.n]>cur.l+next.l){
                    dist[next.n]=cur.l+next.l;
                    q.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist[e];
    }
}