import java.io.*;
import java.util.*;

public class Main {
    public static final int MOD = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[][] dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = 0;
        int y = 1;
        while (y-x <= N-1) {
            if (arr[x] == arr[y]) {
                dp[x][y] = dp[x+1][y-1];
            }
            else {
                dp[x][y] = Math.min(dp[x+1][y]+1, dp[x][y-1]+1);
            }

            x++;
            y++;

            if (y == N) {
                y = y-x+1;
                x = 0;
            }
        }

        System.out.println(dp[0][N-1]);
    }
}