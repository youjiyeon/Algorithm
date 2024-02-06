import java.io.*;
import java.util.*;

public class Main {
    public static int K, N;
    public static long[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        num = new long[K];

        for (int i = 0; i < K; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        long l = 1;
        long r = Integer.MAX_VALUE;
        long mid = 0;
        while (l<r){
            mid = (l+r+1)/2;
            if(solve(mid)) l = mid;
            else r = mid-1;
        }
        System.out.println(l);
    }
    public static boolean solve(long x){
        long cur = 0;
        for (int i = 0; i < K; i++) {
            cur+=num[i]/x;
        }
        return cur>=N;
    }
}