import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr, pick;
    public static boolean[] v;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        pick = new int[m];
        v = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }

        // 사전 순으로 증가
        Arrays.sort(arr);
        perm(0);
        System.out.print(sb);
    }

    public static void perm(int cnt){
        if (cnt==m){
            for (int i:pick){
                sb.append(i).append(" ");
            }
            sb.append("\n");
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