import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, cnt;
    public static char[][] map;
    public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
    public static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        map = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        // 가로일 경우 행만 탐색
        if(map[x][y] == '-'){
            for (int i = 2; i < 4; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];
                if ((nx>=0 && nx<N && ny>=0 && ny<M)
                        && !visit[nx][ny]
                        && map[nx][ny]=='-'){
                    dfs(nx, ny);
                }
            }
        }
        // 세로일 경우 열만 탐색
        if(map[x][y] == '|'){
            for (int i = 0; i < 2; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];
                if ((nx>=0 && nx<N && ny>=0 && ny<M)
                        && !visit[nx][ny]
                        && map[nx][ny]=='|'){
                    dfs(nx, ny);
                }
            }
        }
    }
}