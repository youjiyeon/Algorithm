import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static long wCnt, bCnt, tempW, tempB;
    public static char[][] map;
    public static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
    public static boolean[][] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
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
                // 이어지는 수 비교
                if(!visit[i][j]){
                    visit[i][j] = true;
                    if(map[i][j] == 'W'){
                        tempW = 1;
                        wDfs(i, j);
                        wCnt+=Math.pow(tempW,2);
                    }
                    else {
                        tempB = 1;
                        bDfs(i, j);
                        bCnt+=Math.pow(tempB,2);
                    }
                }
            }
        }
        System.out.println(wCnt+" "+bCnt);
    }

    public static void wDfs(int r, int c){
        for (int i = 0; i < 4; i++) {
            int nr = r + way[i][0];
            int nc = c + way[i][1];
            if((nr>=0 && nr<N && nc>=0 && nc<M)
            && map[nr][nc]=='W'
            && !visit[nr][nc]){
                tempW++;
                visit[nr][nc] = true;
                wDfs(nr, nc);
            }
        }
    }

    public static void bDfs(int r, int c){
        for (int i = 0; i < 4; i++) {
            int nr = r + way[i][0];
            int nc = c + way[i][1];
            if((nr>=0 && nr<N && nc>=0 && nc<M)
                    && map[nr][nc]=='B'
                    && !visit[nr][nc]){
                tempB++;
                visit[nr][nc] = true;
                bDfs(nr, nc);
            }
        }
    }
}