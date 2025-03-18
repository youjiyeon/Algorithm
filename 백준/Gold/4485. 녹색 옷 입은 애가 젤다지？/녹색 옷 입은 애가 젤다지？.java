import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr, dp,
    way = {{0,-1},{-1,0},{1,0},{0,1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cnt = 1;

        while (true) {
            // 입력
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            arr = new int[n][n];
            dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            sb.append("Problem ").append(cnt++).append(": ").append(bfs()).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        dp[0][0] = arr[0][0];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0]+way[i][0];
                int ny = cur[1]+way[i][1];

                if (nx<0 || nx>=n || ny<0 || ny>=n) continue;

                int tmp = dp[cur[0]][cur[1]] + arr[nx][ny];
                if (dp[nx][ny] > tmp) {
                    dp[nx][ny] = tmp;
                    q.offer(new int[] {nx,ny});
                }
            }
        }

        return dp[n-1][n-1];
    }
}