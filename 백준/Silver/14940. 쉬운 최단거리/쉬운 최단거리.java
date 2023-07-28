import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] result, map, way = {{-1,0},{1,0},{0,-1},{0,1}};
    public static int N, M;
    public static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sx = 0, sy = 0;
        map = new int[N][M];
        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(result[i], -1);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==2){
                    sx = i;
                    sy = j;
                    result[i][j] = 0;
                }
                else if (map[i][j] ==0){
                    result[i][j] = 0;
                }
            }
        }

        visit = new boolean[N][M];
        bfs(sx, sy);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visit[x][y] = true;
        int cnt = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int cx = q.peek()[0];
                int cy = q.peek()[1];
                q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cx+way[j][0];
                    int ny = cy+way[j][1];

                    if (nx>=0 && nx<N && ny>=0 && ny<M
                    && !visit[nx][ny]
                    && map[nx][ny]!=0){
                        q.offer(new int[] {nx, ny});
                        visit[nx][ny] = true;
                        result[nx][ny] = cnt;
                    }
                }
            }
            cnt++;
        }
    }
}