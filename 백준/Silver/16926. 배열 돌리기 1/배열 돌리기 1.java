import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, min;
    public static int[][] map, way = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        min = Math.min(N, M);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            turn();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void turn() {

        for (int cnt = 0; cnt < min/2; cnt++) {

            int x = cnt; int y = cnt;
            int temp = map[x][y];

            int w = 0;
            while (w<4) {
                int nx = x + way[w][0];
                int ny = y + way[w][1];

                if (nx >= cnt && nx < N - cnt && ny >= cnt && ny < M - cnt) {
                    map[x][y] = map[nx][ny];
                    x = nx; y = ny;
                } else {
                    w++;
                }
            }
            map[cnt+1][cnt] = temp;
        }
    }
}
