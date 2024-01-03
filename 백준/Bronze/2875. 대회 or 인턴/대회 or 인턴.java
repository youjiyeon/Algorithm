import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        // 2*여 + 1*남
        // -k
        for (int i = 0; i <= k; i++) {
            int tn = n-i;
            int tm = m-(k-i);

            int nn = tn/2;
            max = Math.max(max, Math.min(nn, tm));
        }
        System.out.println(max);
    }
}