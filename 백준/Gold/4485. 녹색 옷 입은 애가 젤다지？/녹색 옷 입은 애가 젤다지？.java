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
    public static int[][] map, dist,
    way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if(n==0) break;

            map = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem "+t+": ").append(dijkstra()).append("\n");
            t++;
        }
        System.out.println(sb);
    }

    private static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[] {0,0,map[0][0]});
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()){
            int x = pq.peek()[0];
            int y = pq.peek()[1];
            pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];

                if(nx<0 || nx>=n || ny<0 || ny>= n){
                    continue;
                }

                if(dist[nx][ny]>dist[x][y]+map[nx][ny]){
                    dist[nx][ny]=dist[x][y]+map[nx][ny];
                    pq.offer(new int[] {nx, ny, map[nx][ny]});
                }
            }
        }
        return dist[n-1][n-1];
    }
}