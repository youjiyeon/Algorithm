import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, R, min;
    public static int[][] map, way = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        min = Math.min(N, M);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = N;
        int m = M;
        for (int i = 0; i < min/2; i++) {
            turn(i, 2*n + 2*m -4);
            n -= 2;
            m -= 2;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void turn(int start, int len) {

        int rLen = R%len;
        for (int i = 0; i < rLen; i++) {

            int x = start; int y = start;
            int temp = map[x][y];

            int w = 0;
            while (w<4) {
                int nx = x + way[w][0];
                int ny = y + way[w][1];

                if (nx >= start && nx < N - start && ny >= start && ny < M - start) {
                    map[x][y] = map[nx][ny];
                    x = nx; y = ny;
                } else {
                    w++;
                }
            }
            map[start+1][start] = temp;
        }
    }
}
