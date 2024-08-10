import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long l = 1;
        long r = k;
        long mid = (l+r)/2;
        long cnt = 0;

        while (l<r) {
            mid = (l+r)/2;
            cnt = 0;

            for (int i = 1; i <= n; i++) {
                cnt+=Math.min(mid/i, n);
            }
            
            if (cnt >= k) {
                r = mid;
            }
            else l = mid+1;
        }

        System.out.println(l);
    }
}