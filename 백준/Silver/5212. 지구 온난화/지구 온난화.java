import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int R, C, minR, minC, maxR, maxC;
    public static char[][] map;
    public static int[][] way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean[][] v;
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        minR = R; minC = C; maxR = 0; maxC = 0;
        map = new char[R][C];
        v = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'X'){
                    q.offer(new int[] {i,j});
                }
            }
        }

        bfs();


        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];

                // 범위를 벗어나면 바다임
                if (nx<0 || nx>=R || ny<0 || ny>=C){
                    cnt++;
                    continue;
                }

                // 이미 땅에서 바다된 것 제외
                if (v[nx][ny])
                    continue;

                if (map[nx][ny] == '.'){
                    cnt++;
                }
            }

            if (cnt>=3){
                v[x][y] = true;
                map[x][y] = '.';
            }
            else {
                minR = Math.min(minR, x);
                minC = Math.min(minC, y);
                maxR = Math.max(maxR, x);
                maxC = Math.max(maxC, y);
            }
        }
    }
}