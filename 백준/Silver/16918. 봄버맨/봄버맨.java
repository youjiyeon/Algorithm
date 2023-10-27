import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int R, C, N;
    public static char[][] map;
    public static int[][] way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static Queue<int[]> boom = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                //if (map[i][j]=='O'){
                    // 초기 폭탄 저장
                    //boom.offer(new int[] {i,j});
                //}
            }
        }

        bfs();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        int time = 1;
        while (time < N){
            // 폭탄 저장
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'O'){
                        boom.offer(new int[] {i,j});
                    }
                }
            }
            int size = boom.size();

            // 나머지 부분 폭탄 설치
            for (int i = 0; i < R; i++) {
                Arrays.fill(map[i], 'O');
            }
            time++;
            if (time == N){
                break;
            }

            // 기존 폭탄 터트림
            while (size-- > 0){
                int x = boom.peek()[0];
                int y = boom.peek()[1];
                boom.poll();

                map[x][y] = '.';
                for (int i = 0; i < 4; i++) {
                    int nx = x + way[i][0];
                    int ny = y + way[i][1];
                    if (nx<0 || nx>=R || ny<0 || ny>=C)
                        continue;
                    map[nx][ny] = '.';
                }
            }
            time++;
        }
    }
}