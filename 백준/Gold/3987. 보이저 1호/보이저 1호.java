import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, ans = Integer.MIN_VALUE;
    public static char c;
    public static char[] cs = {'U','R','D','L'};
    public static int[][] map,
    way = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static boolean[][][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                switch (str.charAt(j)) {
                    case '.':
                        map[i][j] = 0;
                        break;
                    case 'C':
                        map[i][j] = -1;
                        break;
                    case '/':
                        map[i][j] = 1;
                        break;
                    case '\\':
                        map[i][j] = 2;
                        break;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        for (int i = 0; i < 4; i++) {
            v = new boolean[n][m][4];
            if (ans != Integer.MAX_VALUE)
                bfs(x, y, i);
        }

        System.out.println(c);
        System.out.println(ans==Integer.MAX_VALUE? "Voyager" : ans);
    }

    public static void bfs(int x, int y, int w) {
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, w});

        while (!q.isEmpty()) {
            int s = q.size();
            time++;
            while (s-- > 0) {
                int cx = q.peek()[0];
                int cy = q.peek()[1];
                int cw = q.peek()[2];
                q.poll();
                //System.out.println(cx+" "+cy+" "+cw);

                int nx = cx + way[cw][0];
                int ny = cy + way[cw][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == -1) continue;
                if (v[nx][ny][cw]) {
                    ans = Integer.MAX_VALUE;
                    c = cs[w];
                    return;
                }

                v[nx][ny][cw] = true;

                if (map[nx][ny] == 1) {
                    switch (cw) {
                        case 0:
                            cw = 1;
                            break;
                        case 1:
                            cw = 0;
                            break;
                        case 2:
                            cw = 3;
                            break;
                        case 3:
                            cw = 2;
                            break;
                    }
                }
                if (map[nx][ny] == 2) {
                    cw = (3 - cw);
                }

                q.offer(new int[]{nx, ny, cw});
            }
        }

        if (time>ans) {
            ans = time;
            c = cs[w];
        }
    }

}