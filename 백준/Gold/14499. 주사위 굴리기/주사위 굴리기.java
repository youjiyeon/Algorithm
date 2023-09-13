import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] dice = new int[6];
    public static int[][] map,
    way = {{},{0,1},{0,-1},{-1,0},{1,0}};
    // 1 동, 2 서, 3 북, 4 남

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int order = Integer.parseInt(st.nextToken());
            int nx = x + way[order][0];
            int ny = y + way[order][1];
            // 범위 밖은 안됨
            if (nx<0 || nx>=N || ny<0 || ny>=M) continue;

            x = nx; y = ny;
            // 주사위 회전
            turn(order);

            // 이동한 칸이 0이라면 주사위 바닥면 복사
            if(map[nx][ny]==0){
                map[nx][ny] = dice[5];
            }
            // 0이 아니면 주사위 바닥면에 복사 후 map은 0으로
            else {
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }

            sb.append(dice[0]+"\n");
        }
        System.out.println(sb);
    }

    public static void turn(int o){
        int[] copy = dice.clone();
        switch (o){
            // 동
            case 1:
                dice[5] = copy[2];
                dice[2] = copy[0];
                dice[0] = copy[3];
                dice[3] = copy[5];
                break;
            // 서
            case 2:
                dice[5] = copy[3];
                dice[3] = copy[0];
                dice[0] = copy[2];
                dice[2] = copy[5];
                break;
            // 북
            case 3:
                dice[1] = copy[0];
                dice[0] = copy[4];
                dice[4] = copy[5];
                dice[5] = copy[1];
                break;
            // 남
            case 4:
                dice[1] = copy[5];
                dice[0] = copy[1];
                dice[4] = copy[0];
                dice[5] = copy[4];
                break;
        }
    }
}