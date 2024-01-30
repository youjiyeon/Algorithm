import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][][] map = new int[N+1][N+1][11];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int input = Integer.parseInt(st.nextToken());
                for (int k = 1; k <= 10; k++) {
                    map[i][j][k] += map[i][j-1][k];
                }
                map[i][j][input]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= 10; k++) {
                    map[i][j][k] += map[i-1][j][k];
                }
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int cnt = 0;
            int tmp = 0;
            for (int j = 1; j <= 10; j++) {
                tmp = map[x2][y2][j]-map[x1-1][y2][j]-map[x2][y1-1][j]+map[x1-1][y1-1][j];
                if (tmp>=1) cnt++;
            }
            bw.write(cnt+"\n");

        }
        bw.flush();
        bw.close();
    }
}