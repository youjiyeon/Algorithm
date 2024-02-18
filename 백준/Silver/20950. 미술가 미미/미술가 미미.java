import java.io.*;
import java.util.*;

public class Main {
    public static int n, ans = Integer.MAX_VALUE;
    public static int[] diff;
    public static int[][] color;
    public static boolean[] v;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        diff = new int[3];
        color = new int[n][3];
        v = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 비교군
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
            diff[j] = Integer.parseInt(st.nextToken());
        }

        subSet(0, 0);
        System.out.println(ans);
    }

    public static void subSet(int cnt, int tc){
        if (tc>7){
            return;
        }
        if (cnt==n){
            if (tc<2) return;
            int r = 0; int g = 0; int b = 0;
            for (int i = 0; i < n; i++) {
                if (v[i]){
                    r+=color[i][0];
                    g+=color[i][1];
                    b+=color[i][2];
                }
            }
            r/=tc;
            g/=tc;
            b/=tc;
            int tmp = Math.abs(diff[0]-r)+Math.abs(diff[1]-g)+Math.abs(diff[2]-b);
            ans = Math.min(ans, tmp);
            return;
        }

        v[cnt] = true;
        subSet(cnt+1, tc+1);
        v[cnt] = false;
        subSet(cnt+1, tc);
    }
}