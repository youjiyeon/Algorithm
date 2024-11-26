import java.io.*;
import java.util.*;

public class Main {
    static int T, W;
    static int[][] dp;
    static int[] jadu;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        jadu = new int[T];
        dp = new int[T][W+1];
        for (int i = 0; i < T; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < T; i++) {
            jadu[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(Math.max(loop(0, 0), loop(0, 1)));
    }

    static int loop(int idx, int cnt) {
        if (idx >= T) return 0;

        if (dp[idx][cnt] != -1) {
            return dp[idx][cnt];
        }

        int tmp = 0;

        // 2
        if (cnt%2==1 && jadu[idx]==2) {
            tmp = 1;
        }
        // 1
        if (cnt%2==0 && jadu[idx]==1) {
            tmp = 1;
        }

        dp[idx][cnt] = Math.max(dp[idx][cnt], loop(idx+1, cnt)+tmp);

        if (W >= cnt+1) {
            dp[idx][cnt] = Math.max(dp[idx][cnt], loop(idx+1, cnt+1)+tmp);
        }

        return dp[idx][cnt];
    }
}