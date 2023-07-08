import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, min;
    public static boolean[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = 64;
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j)=='W'){
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                // 각 자리마다 8X8 경우를 따져본다.
                check(i, j);
            }
        }
        System.out.println(min);
    }

    public static void check(int r, int c){
        // 바꿔야할 정사각형 개수 저장
        int cnt = 0;
        // 비교 변수
        boolean diff = map[r][c];

        // 탐색
        for (int i=r; i<r+8; i++) {
            for (int j=c; j<c+8; j++) {
                if(diff!=map[i][j]){
                    cnt++;
                }
                diff = !diff;
            }
            diff = !diff;
        }

        // 첫 번째 칸이 하얀 or 검정일 경우
        cnt = Math.min(cnt, 64-cnt);

        // min 갱신
        min = Math.min(min, cnt);

    }
}