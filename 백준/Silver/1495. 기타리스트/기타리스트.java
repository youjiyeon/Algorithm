import java.io.*;
import java.util.*;

public class Main {
    static int n, s, m;
    static int[] volume;
    static int[][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n+1][m+1];

        volume = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -2);
        }

        System.out.println(recur(0, s));
    }

    static int recur(int idx, int cur) {
        if (cur < 0 || cur > m) return -1;
        if (idx == n) return cur;

        if (dp[idx][cur] != -2) return dp[idx][cur];

        return dp[idx][cur] = Math.max(recur(idx+1, cur+volume[idx+1]), recur(idx+1, cur-volume[idx+1]));
    }
}