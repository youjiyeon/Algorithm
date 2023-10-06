import java.io.*;
import java.util.*;

public class Main
{
    public static int n, m, cnt = 0;
    public static char[][] map;
    public static boolean[][] visit;
    public static int[][] way = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visit = new boolean[n][m];
        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j]=='I'){
                    sx = i; sy = j;
                }
            }
        }

        dfs(sx, sy);
        System.out.println(cnt==0?"TT":cnt);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        if (map[x][y]=='P')
            cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + way[i][0];
            int ny = y + way[i][1];

            if (nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny]=='X' || visit[nx][ny])
                continue;
            dfs(nx, ny);
        }
    }


}