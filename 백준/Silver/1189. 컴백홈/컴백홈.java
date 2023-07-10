import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int R, C, K, cnt;
    public static char[][] map;
    public static boolean[][] visit;
    public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cnt = 0;
        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(R-1, 0, 1);
        System.out.println(cnt);
    }

    public static void dfs(int r, int c, int len){
        if (len==K){
            if (r==0 && c==C-1)
                cnt++;
            return;
        }
        visit[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + way[i][0];
            int nc = c + way[i][1];
            if(nr>=0 && nr<R && nc>=0 && nc<C
            && !visit[nr][nc]
            && map[nr][nc]!='T'){
                visit[nr][nc] = true;
                dfs(nr,nc, len+1);
                visit[nr][nc] = false;
            }
        }

    }
}