import java.io.*;
import java.util.*;

public class Main {
    public static int N, L, R, X, ans = 0;
    public static int[] arr;
    public static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        subSet(0, 0);
        System.out.println(ans);
    }

    public static void subSet(int cnt, int sum){
        if (sum>R){
            return;
        }
        if (cnt==N){
            if (sum<L) return;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if (v[i]){
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
            }

            if (max-min>=X) ans++;
            return;
        }

        v[cnt] = true;
        subSet(cnt+1, sum+arr[cnt]);
        v[cnt] = false;
        subSet(cnt+1, sum);
    }
}