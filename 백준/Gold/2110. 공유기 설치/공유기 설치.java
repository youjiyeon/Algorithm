import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, C;
    public static long[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        num = new long[N];

        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(num);

        long l = 1;
        long r = num[N-1]-num[0]+1;
        long mid = 0;
        while (l<r){
            mid = (l+r)/2;
            if(solve(mid)<C) r = mid;
            else l = mid+1;
        }
        System.out.println(l-1);
    }
    public static int solve(long x){
        int cnt = 1;
        long last = num[0];
        for (int i = 0; i < N; i++) {
            long l = num[i];
            if (l - last >= x){
                cnt++;
                last = l;
            }
        }
        return cnt;
    }
}
