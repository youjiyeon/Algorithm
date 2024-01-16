import java.io.*;
import java.util.*;

public class Main {
    public static int[] ans = new int[1001];
    public static void main(String[] args)throws IOException {
        StringBuilder sb = new StringBuilder();

        ans[0] = 0;
        ans[1] = 2;

        for (int i = 2; i <= 1000; i++) {
            int n = 0;
            for (int j = 1; j <= i; j++) {
                if(gcd(i, j)==1)
                    n++;
            }
            ans[i] = ans[i-1]+n;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(ans[n]*2-1).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) {
            return b;
        }
        return gcd(b,r);
    }
}