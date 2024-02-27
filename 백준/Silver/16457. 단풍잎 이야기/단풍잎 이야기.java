import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, ans = Integer.MIN_VALUE;
    public static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m];
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int skill = Integer.parseInt(st.nextToken());
                tmp |= 1 << (skill-1);
            }
            map[i] = tmp;
        }

        com(0, 0, 0);
        System.out.println(ans);
    }

    public static void com(int cnt, int start, int questMask){
        if (cnt==n){
            int questCnt = 0;
            for (int i = 0; i < m; i++) {
                // 퀘스트 달성 가능하면
                if ((questMask & map[i]) == map[i]) {
                    questCnt++;
                }
            }

            ans = Math.max(ans, questCnt);
            return;
        }

        for (int i = start; i < 2*n; i++) {
            com(cnt+1, i+1, questMask | 1<<i);
        }
    }
}