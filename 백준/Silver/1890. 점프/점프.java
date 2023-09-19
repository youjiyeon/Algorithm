import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] map;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int jump = map[i][j];
                if (jump==0)
                    break;
                if (i+jump<N) dp[i+jump][j] += dp[i][j];
                if (j+jump<N) dp[i][j+jump] += dp[i][j];
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}