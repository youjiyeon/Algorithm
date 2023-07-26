import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] map;
    public static boolean[][] visit;
    // 아래, 오른쪽
    public static int[][] way = {{1,0},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (bfs()){
            System.out.println("HaruHaru");
        }
        else System.out.println("Hing");
    }

    private static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        // 맨 위 왼쪽에서 시작
        q.offer(new int[] {0,0});
        visit[0][0] = true;

        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            if (map[x][y]==-1){
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int nx = x + (way[i][0] * map[x][y]);
                int ny = y + (way[i][1] * map[x][y]);

                if (nx >= 0 && nx < N && ny >= 0 && ny < N
                        && !visit[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
        // 도착 지점을 못만나고 끝났을 경우
        return false;
    }
}