import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[] wine;
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        wine = new int[n+1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = wine[1];

        if(n>1){
            dp[2] = wine[1] + wine[2];
        }
        System.out.println(find(n));
    }

    public static int find(int n){
        if(dp[n] == null){
            dp[n] = Math.max(Math.max(find(n-2),find(n-3)+wine[n-1])+wine[n], find(n-1));
        }
        return dp[n];
    }
}