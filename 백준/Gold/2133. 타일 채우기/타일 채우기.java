import java.io.*;
import java.util.*;

public class Main {
    static int row = 3, colum;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        colum = Integer.parseInt(br.readLine());

        dp = new int[colum+1];
        System.out.println(wall(colum));
    }

    static int wall(int n) {
        if (n == 0) return dp[0] = 1;
        if (n == 2) return dp[2] = 3;
        else if (dp[n] == 0) {
            for (int i = 2; i <= n; i+=2) {
                int tmp = i == 2 ? 3 : 2;
                dp[n] += tmp * wall(n-i);
            }
        }

        return dp[n];
    }
}