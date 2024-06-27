// 3초안에 최대 열매

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] card;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        card = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        System.out.println(recur(n));
    }

    static int recur(int idx) {
        if (dp[idx]!=-1) return dp[idx];

        dp[idx] = card[idx];
        for (int i = 1; i < idx+1; i++) {
            dp[idx] = Math.min(dp[idx], recur(idx-i)+recur(i));
        }

        return dp[idx];
    }
}