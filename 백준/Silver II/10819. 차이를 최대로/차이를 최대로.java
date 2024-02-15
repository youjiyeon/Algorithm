import java.io.*;
import java.util.*;

public class Main {
    public static int n, ans = Integer.MIN_VALUE;
    public static int[] arr, pick;
    public static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        pick = new int[n];
        v = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(ans);
    }

    public static void perm(int cnt){
        if (cnt==n){
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum+=Math.abs(pick[i-1]-pick[i]);
            }

            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i]){
                v[i] = true;
                pick[cnt] = arr[i];
                perm(cnt+1);
                v[i] = false;
            }
        }
    }
}