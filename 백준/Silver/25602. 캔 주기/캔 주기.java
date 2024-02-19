/**
 * if (can[i]<=0) continue;
 */

import java.io.*;
import java.util.*;

public class Main {
    public static int N, K, ans = Integer.MIN_VALUE;
    public static int[] can, pick;
    public static int[][] cat1, cat2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        can = new int[N];
        pick = new int[K*2];
        cat1 = new int[K][N];
        cat2 = new int[K][N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            can[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cat1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cat2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0);
        System.out.println(ans);
    }

    public static void perm(int cnt){
        if (cnt==(K*2)){
            int tmp = 0;
            for (int i = 0; i < K; i++) {
                tmp+=cat1[i][pick[i]];
            }
            for (int i = K; i < K*2; i++) {
                tmp+=cat2[i-K][pick[i]];
            }

            ans = Math.max(ans, tmp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (can[i]<=0) continue;
            can[i]--;
            pick[cnt] = i;
            perm(cnt+1);
            can[i]++;
        }
    }
}