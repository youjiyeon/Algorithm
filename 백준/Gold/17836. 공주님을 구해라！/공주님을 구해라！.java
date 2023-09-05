import java.io.*;
import java.util.*;

public class Main {

    public static class Node{
        int x;
        int y;
        boolean sword;

        public Node(int x, int y, boolean sword) {
            this.x = x;
            this.y = y;
            this.sword = sword;
        }
    }
    public static boolean[][][] visit;
    public static int[][] map, way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int N, M, T, min = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if (min>T){
            System.out.println("Fail");
        }
        else System.out.println(min);
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        // x, y, 검 유무
        q.offer(new Node(0, 0, false));
        visit[0][0][0] = true;
        int cnt = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();
                
                if (cnt>T)
                    return;

                if (cur.x==N-1 && cur.y==M-1){
                    min = cnt;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + way[i][0];
                    int ny = cur.y + way[i][1];

                    if (nx<0 || nx>=N || ny<0 || ny>=M)
                        continue;

                    if (!cur.sword){
                        if (map[nx][ny]==0 && !visit[nx][ny][0]){
                            visit[nx][ny][0] = true;
                            q.offer(new Node(nx, ny, cur.sword));
                        }
                        if (map[nx][ny]==2 && !visit[nx][ny][1]){
                            visit[nx][ny][1] = true;
                            q.offer(new Node(nx, ny, true));
                        }
                    }
                    else {
                        if ((map[nx][ny]==0 || map[nx][ny]==1) && !visit[nx][ny][1]){
                            visit[nx][ny][1] = true;
                            q.offer(new Node(nx, ny, true));
                        }
                    }
                }
            }
            cnt++;
        }
    }
}