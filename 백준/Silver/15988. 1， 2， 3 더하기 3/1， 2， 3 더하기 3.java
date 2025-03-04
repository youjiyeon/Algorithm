import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000009;
    static int n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        dp = new long[1000001];
        Arrays.fill(dp, -1);
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(makeNumber(n)).append("\n");
        }

        System.out.println(sb);
    }

    static long makeNumber(int num) {
        // 기저
        if (num == 0 || num == 1) return 1;
        if (num == 2) return 2;
        if (num == 3) return 4;
        if (dp[num] != -1) return dp[num];

        long ret = 0;
        if (num-1 >= 0) ret += makeNumber(num-1)%MOD;
        if (num-2 >= 0) ret += makeNumber(num-2)%MOD;
        if (num-3 >= 0) ret += makeNumber(num-3)%MOD;

        return dp[num]=ret%MOD;
    }
}