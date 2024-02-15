import java.io.*;
import java.util.*;

public class Main {
    public static int n, s, ans = 0;
    public static int[] arr;
    public static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        v = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);
        if (s==0) ans--;
        System.out.println(ans);
    }

    public static void subset(int cnt){
        if (cnt==n){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (v[i]) sum+=arr[i];
            }

            if (sum==s) ans++;
            return;
        }

        v[cnt] = true;
        subset(cnt+1);
        v[cnt] = false;
        subset(cnt+1);
    }
}