import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, ans = 0;
    public static boolean[][] v;
    public static int[][] map, check,
            way = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                switch (c) {
                    case 'U':
                        map[i][j] = 0;
                        break;
                    case 'R':
                        map[i][j] = 1;
                        break;
                    case 'D':
                        map[i][j] = 2;
                        break;
                    case 'L':
                        map[i][j] = 3;
                        break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0 && !v[i][j]) {
                    //list = new ArrayList<>();
                    if (dfs(i, j) == 1) ans++;

                        //ans += list.size();
                        /*for (int k = 0; k < list.size(); k++) {
                            check[list.get(k)[0]][list.get(k)[1]] = true;
                        }*/

                } else if (check[i][j] == 1) ans++;
            }
        }

        System.out.println(ans);
    }

    public static int dfs(int x, int y) {
        //list.add(new int[] {x, y});


        if (x<0 || x>=n || y<0 || y>= m) {
            return 1;
        }
        if (v[x][y]) {
            return -1;
        }
        if (check[x][y]==1) {
            return 1;
        }

        v[x][y] = true;
        int nx = x+way[map[x][y]][0];
        int ny = y+way[map[x][y]][1];

        check[x][y] = dfs(nx, ny);
        v[x][y] = false;

        return check[x][y];
    }
}