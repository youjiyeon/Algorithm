import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long[] len, cost;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        len = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }

        cost = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long min = cost[0];
        for (int i = 0; i < n-1; i++) {
            min = Math.min(min, cost[i]);
            sum += min*len[i];
        }

        System.out.println(sum);
    }
}