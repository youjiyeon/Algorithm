import java.io.*;
import java.util.*;

public class Main {
    public static int n, tmp, cnt = 0;
    public static int[][] map, way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean[][] v;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        v = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]==1 && !v[i][j]) {
                    tmp = 1;
                    v[i][j] = true;

                    dfs(i, j);

                    list.add(tmp);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        Collections.sort(list);
        for (int i = 0; i < cnt; i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + way[i][0];
            int ny = y + way[i][1];

            if (nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if (map[nx][ny]==1 && !v[nx][ny]) {
                v[nx][ny] = true;
                tmp++;
                dfs(nx, ny);
            }
        }
    }
}