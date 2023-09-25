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
    public static int n, m;
    public static int[][] map,
    way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int[] dist;
    public static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dist = new int[n+1];
        list = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i ++) list[i] = new ArrayList<>();
        for(int i = 1 ; i <= m ; i ++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
        }

        int sum;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            sum = 0;
            sum += dijkstra(x,i);
            sum += dijkstra(i,x);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    private static int dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        pq.offer(new Node(s, 0));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int curr = currNode.n;

            if(currNode.d > dist[curr]) continue;

            for(Node next: list[curr]){
                if(dist[next.n] > dist[curr] + next.d){
                    dist[next.n] = dist[curr] + next.d;
                    pq.offer(next);
                }
            }
        }
        return dist[e];
    }


}