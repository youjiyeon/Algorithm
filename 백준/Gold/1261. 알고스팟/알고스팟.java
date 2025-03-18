import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr, dp,
    way = {{0,-1},{-1,0},{1,0},{0,1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j)-'0';
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        dp[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0]+way[i][0];
                int ny = cur[1]+way[i][1];

                if (nx<0 || nx>=n || ny<0 || ny>=m) continue;

                int tmp = dp[cur[0]][cur[1]] + arr[nx][ny];
                if (dp[nx][ny] > tmp) {
                    dp[nx][ny] = tmp;
                    q.offer(new int[] {nx,ny});
                }
            }
        }

        return dp[n-1][m-1];
    }
}