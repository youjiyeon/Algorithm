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

        while (l<r){
            mid = (l+r)/2;
            cnt = 0;

            for (int i = 1; i <= n; i++) {
                // n을 초과하면 안되서
                cnt+=Math.min(mid/i, n);
            }
            // cnt가 많다는 것은 임의의 x(mid)보다 작은 수가 b[k]보다 많다는 뜻
            if (cnt>=k){
                r = mid;
            }
            else l = mid+1;
        }

        System.out.println(l);
    }
}