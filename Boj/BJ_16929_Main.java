import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 문제 설명
* 자신이랑 같은 값이 반복되어서
* 결국 자신의 자리까지 도달하는 지 확인
 */

public class BJ_16929_Main {
    public static int N, M, sx, sy;
    public static char[][] map;
    public static boolean[][] visit;
    public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                visit = new boolean[N][M];
                sx = i;
                sy = j;

                if(dfs(i,j,1)){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }

    public static boolean dfs(int x, int y, int cnt) {
        
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + way[i][0];
            int ny = y + way[i][1];

            if(nx>=0 && nx<N && ny>=0 && ny<M
                    && map[nx][ny] == map[x][y]){
                if(!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    if(dfs(nx, ny, cnt+1)) return true;
                }
                else{
                    if(nx==sx && ny==sy && cnt>=4){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
