import java.io.*;
import java.util.*;

public class Main {
    public static int n, s, ans = 0;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pick(0, 0);
        if (s==0) ans--;
        System.out.println(ans);
    }
    public static void pick(int cnt, int sum){
        if (cnt==n){
            if (sum==s) ans++;
            return;
        }
        pick(cnt+1, sum+arr[cnt]);
        pick(cnt+1, sum);
    }
}