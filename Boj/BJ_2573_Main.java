import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_Main {
    public static int N, M;
    public static int[][] map,
    way = {{-1,0},{1,0},{0,-1},{0,1}};
    public static boolean[][] visit;
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int i = 0;

        // 몇년 이후에 섬이 분열되는지
        loop: while (true){
            visit = new boolean[N][M];
            boolean flag = false;
            //map = copy.clone();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(!visit[j][k] && map[j][k]>0){
                        if(flag) {
                            System.out.println(i);
                            break loop;
                        }
                        visit[j][k] = true;
                        bfs(j,k);
                        flag = true;
                    }
                }
            }
            if(!flag){
                System.out.println(0);
                break loop;
            }
            Melt();
            i++;
        }
    }

    private static void bfs(int j, int k) {

        q.add(new int[] {j,k});
        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + way[i][0];
                int ny = y + way[i][1];

                if(isRight(nx,ny)){
                    visit[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }
    }

    private static boolean isRight(int nx, int ny) {
        if(nx>=0 && nx<N && ny>=0 && ny<M
        && !visit[nx][ny] && map[nx][ny]>0)
        {
            return true;
        }
        return false;
    }


    // 빙하를 녹이는 함수.
    public static void Melt() {
        Queue<int[]> q = new LinkedList<>();

        // visited 배열을 만드는 이유

        // visited 배열이 없다면,
        // 만약 1 2 가 있는 상태에서 1이 먼저 녹아서 0이 될 경우
        // 2는 녹아서 없어진 1 자리도 0이라고 판단하여
        // 필요 이상으로 더 많은 값을 녹이게 되어 버림.
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dx, dy;
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            int seaNum = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.

            for (int i = 0; i < 4; i++) {
                dx = x + way[i][0];
                dy = y + way[i][1];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                if (!visited[dx][dy] && map[dx][dy] == 0) {
                    seaNum++;
                }
            }

            if (map[x][y] - seaNum < 0) {
                map[x][y] = 0;
            } else {
                map[x][y] -= seaNum;
            }
        }
    }
}
