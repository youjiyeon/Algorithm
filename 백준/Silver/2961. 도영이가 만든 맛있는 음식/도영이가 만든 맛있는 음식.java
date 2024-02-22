import java.io.*;
import java.util.*;

public class Main {
    public static int n, ans = Integer.MAX_VALUE;
    public static int[] s, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        s = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            pick(i+1, s[i], b[i]);
        }

        System.out.println(ans);
    }
    public static void pick(int cnt, int sSum, int bSum){
        if (cnt==n){
            ans = Math.min(ans, Math.abs(sSum-bSum));
            return;
        }

        pick(cnt+1, sSum, bSum);
        pick(cnt+1, sSum*s[cnt], bSum+b[cnt]);
    }
}