import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static final int mod = 1000000000;
    public static int[][] cache = new int[202][202];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                cache[i][j] = -1;
            }
        }

        System.out.print(make(n, k));
    }

    public static int make(int rest, int sum){
        if (sum == 0) {
            if (rest == 0) return 1;
            else return 0;
        }

        if (rest < 0) return 0;
        if (cache[rest][sum] != -1) return cache[rest][sum];
        cache[rest][sum] = (make(rest-1,sum) + make(rest,sum-1)) % mod;

        return cache[rest][sum];
    }
}