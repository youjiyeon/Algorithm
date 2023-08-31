import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map, dp,
            way = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }

    static int dfs(int x, int y){
        if (dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + way[i][0];
            int ny = y + way[i][1];
            if (nx<0 || nx>=N || ny<0 || ny>=N) continue;

            if (map[x][y]<map[nx][ny]) {
                dp[x][y] = Math.max(dfs(nx, ny) + 1, dp[x][y]);
                dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}