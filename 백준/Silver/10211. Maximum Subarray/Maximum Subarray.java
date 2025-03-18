import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- >  0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            int max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int in = Integer.parseInt(st.nextToken());
                arr[i] = Math.max(arr[i-1]+in, in);
                max = Math.max(max, arr[i]);
            }
            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}