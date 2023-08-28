import java.io.*;
import java.util.*;

public class Main {
    static int N, ex, ey;
    static int[][] way = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visit = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        System.out.println(bfs(sx, sy));
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visit[x][y] = true;
        int len = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int cx = q.peek()[0];
                int cy = q.peek()[1];
                q.poll();
                if (cx == ex && cy ==ey){
                    return len;
                }

                for (int i = 0; i < 6; i++) {
                    int nx = cx + way[i][0];
                    int ny = cy + way[i][1];

                    if (nx>=0 && nx<N && ny>=0 && ny<N
                    && !visit[nx][ny]){
                        q.offer(new int[] {nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
            len++;
        }

        return -1;
    }
}