import java.io.*;
import java.util.*;

public class Main
{
    public static int n, m;
    public static int[][] map,
    way = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        for (int i = 0; i < m; i++) {
            if (map[0][i]==0){
                if(dfs(0,i)){
                    System.out.println("YES");
                    System.exit(0);
                }
            }
        }

        System.out.println("NO");
    }

    private static boolean dfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        map[x][y] = 2;

        while (!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            if (cx==n-1)
                return true;

            for (int i = 0; i < 4; i++) {
                int nx = cx + way[i][0];
                int ny = cy + way[i][1];

                if (nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] == 1 || map[nx][ny] == 2)
                    continue;

                q.offer(new int[] {nx, ny});
                map[nx][ny] = 2;
            }
        }

        return false;
    }
}