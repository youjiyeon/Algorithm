import java.io.*;
import java.util.*;

public class Main {
    public static int N, min = Integer.MAX_VALUE;
    public static int[][] map,
    way = {{1,0},{0,1},{-1,0},{0,-1}};
    public static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && map[i][j] == 1){
                    bfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0){
                    visit = new boolean[N][N];
                    bridge(i, j);
                }
            }
        }

        System.out.println(min);
    }

    public static void bfs(int x, int y, int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visit[x][y] = true;
        map[x][y] = cnt+1;

        while (!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + way[i][0];
                int ny = cy + way[i][1];

                if (nx<0 || nx>=N || ny<0 || ny>= N) continue;
                if (!visit[nx][ny] && map[nx][ny] == 1){
                    q.offer(new int[] {nx, ny});
                    visit[nx][ny] = true;
                    map[nx][ny] = cnt+1;
                }
            }
        }
    }

    public static void bridge(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        int len = 0;
        int val = map[x][y];

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0) {

                int cx = q.peek()[0];
                int cy = q.peek()[1];
                q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cx + way[i][0];
                    int ny = cy + way[i][1];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (!visit[nx][ny] && map[nx][ny] != val) {
                        if (map[nx][ny]!=0){
                            min = Math.min(min, len);
                            return;
                        }
                        q.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
            len++;
        }
    }
}