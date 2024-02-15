import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr, pick;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        pick = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0);
        System.out.println(sb);
    }

    public static void perm(int cnt){
        if (cnt==m){
            for (int i:pick) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            pick[cnt] = arr[i];
            perm(cnt + 1);
        }
    }
}