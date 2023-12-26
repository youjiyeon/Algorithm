import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] map, change,
            way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        change = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(change[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        bfs();
        System.out.println(change[n-1][n-1]);
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        change[0][0] = 0;
        visit[0][0] = true;

        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            int cnt = change[x][y];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];
                int nc = cnt;

                if (nx<0 || nx>=n || ny<0 || ny>=n) {
                    continue;
                }
                if (map[nx][ny]==0){
                    nc++;
                }
                if (change[nx][ny]>nc){
                    change[nx][ny] = nc;
                    q.offer(new int[] {nx, ny});
                }

            }
        }
    }
}