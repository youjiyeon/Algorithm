import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] pick;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pick = new int[m];

        perm(0);
        System.out.print(sb);
    }

    public static void perm(int cnt){
        if (cnt==m){
            for(int i:pick){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            pick[cnt] = i;
            perm(cnt+1);
        }
    }
}