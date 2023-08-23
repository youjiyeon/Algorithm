import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, K;
    public static int min = 987654321;
    public static int[][] a, copy, t,
    way = {{1,0},{0,1},{-1,0},{0,-1}}; // 우 하 좌 상
    public static int[] pick;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 그래프 입력
        a = new int[N+1][M+1];
        pick = new int[K];
        visit = new boolean[K];
        t = new int[K][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 입력
        for (int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            t[j][0] = r;
            t[j][1] = c;
            t[j][2] = s;
        }

        per(0);

        System.out.println(min);
    }

    private static void per(int cnt) {
        if (cnt==K){
            copy = new int[N+1][M+1];
            copyMap();
            for (int i = 0; i < K; i++) {
                turn(t[pick[i]][0], t[pick[i]][1], t[pick[i]][2]);
            }

            // 최소값
            min = Math.min(calMin(), min);

            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visit[i]) {
                visit[i] = true;
                pick[cnt] = i;
                per(cnt + 1);
                visit[i] = false;
            }
        }
    }

    private static void turn(int r, int c, int S) {
        for(int s=1; s<=S; s++) {
            //위
            int upTmp = copy[r-s][c+s];
            for(int y = c+s; y > c-s; y--) {
                copy[r-s][y] = copy[r-s][y-1];
            }
            //오른쪽
            int rightTmp = copy[r+s][c+s];
            for(int x = r+s; x > r-s; x--) {
                copy[x][c+s] = copy[x-1][c+s];
            }
            copy[r-s+1][c+s] = upTmp;
            //아래
            int leftTmp = copy[r+s][c-s];
            for(int y = c-s; y < c+s; y++) {
                copy[r+s][y] = copy[r+s][y+1];
            }
            copy[r+s][c+s-1] = rightTmp;
            //왼쪽
            for(int x = r-s; x < r+s; x++) {
                copy[x][c-s] = copy[x+1][c-s];
            }
            copy[r+s-1][c-s] = leftTmp;
        }
    }
    static int calMin(){
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += copy[i][j];
            }
            result = Math.min(result, sum);
        }
        return result;
    }

    static void copyMap(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copy[i][j] = a[i][j];
            }
        }
    }
}
