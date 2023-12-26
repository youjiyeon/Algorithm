import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m, sx, sy, ex, ey;
    public static char[][] map;
    public static boolean[][] v;
    public static int[][] way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken())-1;
        sy = Integer.parseInt(st.nextToken())-1;
        ex = Integer.parseInt(st.nextToken())-1;
        ey = Integer.parseInt(st.nextToken())-1;

        map = new char[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        bfs();
    }

    public static void bfs(){
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        q.offer(new int[] {sx, sy, 0});
        v[sx][sy] = true;

        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            int cnt = q.peek()[2];
            q.poll();
            if (x==ex && y==ey){
                System.out.println(cnt+1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny]) {
                    continue;
                }
                if (map[nx][ny]!='1'){
                    q.offer(new int[] {nx, ny, cnt});
                    v[nx][ny] = true;
                }
                else {
                    q.offer(new int[] {nx, ny, cnt+1});
                    v[nx][ny] = true;
                }
            }
        }
    }
}