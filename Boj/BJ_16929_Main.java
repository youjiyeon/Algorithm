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
        // 입력
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
        //
        
        // 각 칸마다 dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                visit = new boolean[N][M];
                sx = i;
                sy = j;
                    
                // 사이클이 존재하면
                if(dfs(i,j,1)){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        
        // 사이클이 존재하지 않는다면
        System.out.println("No");
        //

    }

    public static boolean dfs(int x, int y, int cnt) {
        
        // 방문 처리
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + way[i][0];
            int ny = y + way[i][1];
               
            // 경계 확인
            if(nx>=0 && nx<N && ny>=0 && ny<M
                    && map[nx][ny] == map[x][y]){
                
                // 방문 확인
                if(!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    
                    // 다음 자리로 이동
                    if(dfs(nx, ny, cnt+1)) return true;
                }
                else{
                    // cnt가 4이상이고 자기자신이라면
                    if(nx==sx && ny==sy && cnt>=4){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
