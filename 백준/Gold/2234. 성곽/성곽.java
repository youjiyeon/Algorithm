import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][][] map;
    static boolean[][] v;
    static StringTokenizer st;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static class Node{
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new boolean[N][M][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 4; k++) {
                    if ((a&(1<<k))==(1<<k)){
                        map[i][j][k] = true;
                    }
                }
            }
        }

        int totalRoomCnt = 0;
        int maxRoomSize = Integer.MIN_VALUE;

        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!v[i][j]){
                    totalRoomCnt++;
                    maxRoomSize = Math.max(maxRoomSize, bfs(i, j));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                for(int d = 0 ;d < 4 ; d ++){
                    if(map[i][j][d]){
                        v = new boolean[N][M];
                        map[i][j][d] = false;
                        ans = Math.max(ans, bfs(i, j));
                        map[i][j][d] = true;
                    }
                }
            }
        }

        System.out.println(totalRoomCnt);
        System.out.println(maxRoomSize);
        System.out.println(ans);
    }

    private static int bfs(int i, int j) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(i, j));
        int localRoomSize = 0;

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(v[curr.r][curr.c]) continue;
            v[curr.r][curr.c] = true;
            localRoomSize ++;

            for(int d = 0 ;d < 4 ; d ++){ // 상 우 하 좌
                if(map[curr.r][curr.c][d]) continue;

                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(!isValid(nr, nc)) continue;
                if(v[nr][nc]) continue;

                q.offer(new Node(nr, nc));
            }
        }
        return localRoomSize;
    }
    private static boolean isValid(int nr, int nc){
        return (nr>=0 && nr<N && nc>=0 && nc<M);
    }
}