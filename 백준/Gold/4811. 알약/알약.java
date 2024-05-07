import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[31][62];
        n = Integer.parseInt(br.readLine());
        
        while (n != 0) {
            sb.append(recur(n, 0)).append("\n");
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }

    public static long recur(int w, int h) {
        if (dp[w][h] != 0){
            return dp[w][h];
        }

        if (w==0 && h==0) {
            return 1;
        }

        if (w-1>=0) {
            dp[w][h] += recur(w - 1, h + 1);
        }
        if (h-1>=0) {
            dp[w][h] += recur(w, h - 1);
        }

        return dp[w][h];
    }
}