import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long l = 1;
        long r = K;
        long mid = 0;
        long cnt = 0;

        while (l<r){
            mid = (l+r)/2;
            cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid/i, N);
            }

            if (cnt<K){
                l = mid+1;
            } else {
                r = mid;
            }
        }

        System.out.println(l);
    }
}
