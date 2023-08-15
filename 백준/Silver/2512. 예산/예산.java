import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static long[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new long[N];

        long max = Long.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, num[i]);
        }
        M = Integer.parseInt(br.readLine());
        Arrays.sort(num);

        long l = 1;
        long r = max;
        long mid = 0;
        while (l<r){
            mid = (l+r+1)/2;
            if(solve(mid)) l = mid;
            else r = mid-1;
        }
        System.out.println(l);
    }
    public static boolean solve(long x){
        int cur = 0;
        for (int i = 0; i < N; i++) {
            if (num[i]>x){
                cur+=x;
            }
            else cur+=num[i];
        }
        return cur<=M;
    }
}
