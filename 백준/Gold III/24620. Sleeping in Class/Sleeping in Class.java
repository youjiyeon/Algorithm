import java.io.*;
import java.util.*;

public class Main {
    public static int T, N;
    public static int[] sum;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            sum = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }
            for (int i = N; i >= 1; i--) {
                if (isSame(i)) {
                    sb.append(N - i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean isSame(int divisor) {
        if (sum[N] % divisor != 0) return false;
        int s = 0;
        int e;

        for (e = 1; e <= N; e++) {
            if (sum[e] - sum[s] > sum[N]/divisor){
                return false;
            }
            else if (sum[e] - sum[s] < sum[N]/divisor){
                continue;
            }
            s = e;
        }
        return s==e - 1?true:false;
    }
}