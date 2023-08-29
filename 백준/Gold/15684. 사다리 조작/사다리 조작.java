import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H, min = 4;
    // a 세로줄에서 b 가로줄
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        if (M==0){
            System.out.println(0);
        }
        else {
            map = new int[H+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
                map[a][b+1] = 2;
            }

            dfs(1, 0);
            System.out.println(min<4 ? min : -1);
        }
    }

    private static void dfs(int x, int cnt){
        if (min<=cnt)
            return;
        else {
            if (play()){
                min = cnt;
                return;
            }
        }

        for (int i = x; i < H+1; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(i, cnt+1);
                    map[i][j] = map[i][j+1] = 0;
                }
            }
        }
    }

    private static boolean play(){
        for (int i = 1; i <= N; i++) {
            int x = 1; int y = i;
            for (int j = 0; j < H; j++) {
                if (map[x][y] == 1){
                    y++;
                } else if (map[x][y] == 2) {
                    y--;
                }
                x++;
            }
            if (y != i){
                return false;
            }
        }

        return true;
    }
}