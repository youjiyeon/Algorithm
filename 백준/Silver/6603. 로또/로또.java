import java.io.*;
import java.util.*;

public class Main {
    public static int k;
    public static int[] S, pick;
    public static boolean[] v;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k==0) break;

            S = new int[k];
            pick = new int[6];
            v = new boolean[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            perm(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void perm(int cnt){
        if (cnt==6){
            for (int i:pick){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < k; i++) {
            if (cnt!=0){
                if (pick[cnt-1]>=S[i]) continue;
            }
            if (!v[i]) {
                v[i] = true;
                pick[cnt] = S[i];
                perm(cnt+1);
                v[i] = false;
            }
        }
    }
}