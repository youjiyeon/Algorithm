import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, max;
    static int[][] map;
    static int[][] way = {{-1,0},{0,-1},{1,0},{0,1}};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        map = new int[N][M];
        visit = new boolean[N+1][M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0,0,0);
        System.out.println(max);
    }

    // 인접하지 않은 K개의 칸을 선택
    public static void solve(int cnt, int r, int c, int sum){
        if(cnt==K){
            // 최대값 비교
            max = Math.max(max, sum);
            return;
        }
        else {
            for (int i = r; i < N; i++) {
                for (int j = c; j < M; j++) {
                    if (!visit[i][j]) {
                        if (isRight(i, j)) {
                            visit[i][j] = true;
                            solve(cnt + 1, r, c, sum + map[i][j]);
                            visit[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    public static boolean isRight(int r, int c){
        boolean flag = true;
        for (int k = 0; k < 4; k++) {
            int nr = r + way[k][0];
            int nc = c + way[k][1];

            if(nr>=0 && nr<N && nc>=0 && nc<M){
                if(visit[nr][nc]) {
                    flag = false;
                }
            }
        }
        return flag;
    }
}