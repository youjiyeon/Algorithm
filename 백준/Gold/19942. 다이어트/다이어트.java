/*
조건
p, f, s, v 값 도달

결과값
최소 비용
 */
import java.io.*;
import java.util.*;

public class Main {
    public static int n, ans = Integer.MAX_VALUE;
    public static int[] m = new int[4];
    public static boolean[] visit, check;
    public static int[][] map;
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[n+1][5];
        visit = new boolean[n+1];
        check = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            set(i, 0,0,0,0,0, i);
        }

        if (ans==Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }

    public static void set(int cnt, int p, int f, int s, int v, int sum, int target) {
        if (cnt == n+1) {
            if (p<m[0] || f<m[1] || s<m[2] || v<m[3]) return;

            if (ans>=sum) {
                if (ans>sum) list.clear();
                ans = sum;
                StringBuilder str = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    if (visit[i]) {
                        str.append(i).append(" ");
                    }
                }
                list.add(str.toString());
            }
            return;
        }

        if (cnt==target) {
            visit[cnt] = true;
            set(cnt+1, p+map[cnt][0], f+map[cnt][1], s+map[cnt][2], v+map[cnt][3], sum+map[cnt][4], target);
            visit[cnt] = false;
        }
        else {
            visit[cnt] = true;
            set(cnt+1, p+map[cnt][0], f+map[cnt][1], s+map[cnt][2], v+map[cnt][3], sum+map[cnt][4], target);
            visit[cnt] = false;
            set(cnt+1, p, f, s, v, sum, target);
        }
    }
}