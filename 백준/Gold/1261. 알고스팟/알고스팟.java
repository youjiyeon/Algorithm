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
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j+1] = str.charAt(j)-'0';
            }
        }

        System.out.println(dijstra());
    }

    private static int dijstra() {
        //q[0] -> r, [1] -> c, [2] -> d
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        q.offer(new int[] {1,1,map[1][1]});
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[1][1] = map[1][1];

        while (!q.isEmpty())
        {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];

                if(nx<1 || nx>n || ny<1 || ny>m)
                    continue;
                if (dist[nx][ny]>dist[x][y]+map[nx][ny]){
                    dist[nx][ny]=dist[x][y]+map[nx][ny];
                    q.offer(new int[] {nx, ny, map[nx][ny]});
                }
            }
        }
        return dist[n][m];
    }


}