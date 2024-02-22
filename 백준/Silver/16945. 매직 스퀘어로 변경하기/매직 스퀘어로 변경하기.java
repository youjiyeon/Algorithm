import java.io.*;
import java.util.*;

public class Main {
    public static int n = 3, ans = Integer.MAX_VALUE;
    public static int[][] map = new int[n][n];
    public static boolean[] v = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pick(0, 0);
        System.out.println(ans);
    }
    public static void pick(int cnt, int sum){
        if (cnt==9 && isMagic()){
            ans = Math.min(ans, sum);
            return;
        }

        int x = cnt/n;
        int y = cnt%n;

        for (int i = 1; i <= 9; i++) {
            if (!v[i]){
                int tmp = map[x][y];
                v[i] = true;
                map[x][y] = i;
                pick(cnt+1, sum+Math.abs(tmp-i));
                v[i] = false;
                map[x][y] = tmp;
            }

        }
    }

    public static boolean isMagic() {
        int s = 0;

        // 행 비교
        for (int i = 0; i < n; i++) {
            s = 0;
            for (int j = 0; j < n; j++) {
                s+=map[i][j];
            }
            if (s!=15) return false;
        }
        
        // 열 비교
        for (int i = 0; i < n; i++) {
            s = 0;
            for (int j = 0; j < n; j++) {
                s+=map[j][i];
            }
            if (s!=15) return false;
        }

        // / 대각선 비교
        s = 0;
        for (int i = 0; i < n; i++) {
            s+=map[i][i];
        }
        if (s!=15) return false;

        // \ 대각선 비교
        s = 0;
        for (int i = 0; i < n; i++) {
            s+=map[(n-1)-i][i];
        }
        if (s!=15) return false;

        return true;
    }
}