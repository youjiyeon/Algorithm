import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] map, dp,
            way = {{0, 1},{0, -1},{1, 0},{-1, 0}};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (true) {
           N = Integer.parseInt(br.readLine());
           if (N==0) break;

           map = new int[N][N];
           dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();

/*            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }*/

            sb.append("Problem ").append(t).append(": ").append(dp[N-1][N-1]).append("\n");
            t++;
        }

        System.out.print(sb);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});

        dp[0][0] = map[0][0];

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x+way[i][0];
                int ny = y+way[i][1];

                if (nx<0 || nx>=N || ny<0 || ny>=N) {
                    continue;
                }

                if (dp[nx][ny] > dp[x][y]+map[nx][ny]) {
                    dp[nx][ny] = dp[x][y]+map[nx][ny];
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}