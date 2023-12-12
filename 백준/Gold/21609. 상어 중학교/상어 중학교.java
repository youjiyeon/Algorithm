import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, mx, my, maxCnt, rainCnt, ans = 0;
    public static int[][] map,
            way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean[][] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 큰 블록 그룹 존재 여부
        // 점수 획득
        // 블록 제거
        // 중력 작용
        // 90도 반시계 회전
        // 중력 작용
        while(true){
            maxCnt = 0;
            rainCnt = 0;
            // 가장 큰 블록 그룹 찾기
            findBig();

            if (maxCnt<=1){
                break;
            }

            // 점수 획득
            ans += Math.pow(maxCnt, 2);

            // 블록 제거
            bfs(mx, my, 'd');

            // 중력
            gravity();

            // 반시계
            turn();

            // 중력
            gravity();

            // 프린트
            //printMap();

        }

        System.out.println(ans);
    }

    public static void initRain(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && visit[i][j]){
                    visit[i][j] = false;
                }
            }
        }
    }

    private static void turn() {
        // 0,0 -> 0, n-1
        // 0,1 -> 1, n-1

        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = map[j][(n-1)-i];
            }
        }

        map = copy;
    }

    public static void gravity(){
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]>=0){
                    int idx = i+1;
                    while (true){
                        if (idx>=n || map[idx][j]!=-2){
                            break;
                        }
                        idx++;
                    }
                    if(idx-1 != i) {
                        map[idx - 1][j] = map[i][j];
                        map[i][j] = -2;
                    }
                }
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void findBig() {
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]>0 && !visit[i][j]){
                    initRain();
                    bfs(i,j,'f');
                }
            }
        }
    }

    public static void bfs(int x, int y, char mode){

        // 찾기 모드일 경우
        if (mode=='f'){
            int val = map[x][y];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {x, y});
            visit[x][y] = true;
            int c = 0;
            int rainbow = 0;

            while (!q.isEmpty()){
                int cx = q.peek()[0];
                int cy = q.peek()[1];
                q.poll();
                if (map[cx][cy] == 0){
                    rainbow++;
                }
                c++;

                for (int i = 0; i < 4; i++) {
                    int nx = cx + way[i][0];
                    int ny = cy + way[i][1];

                    if (nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny]<0 || visit[nx][ny])
                        continue;
                    if (map[nx][ny]==0 || map[nx][ny]==val) {
                        q.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
            if (com(c, rainbow, x, y)){
                maxCnt = c;
                rainCnt = rainbow;
                mx = x;
                my = y;
            }
        }

        // delete일 경우
        else if (mode=='d'){
            visit = new boolean[n][n];
            int val = map[x][y];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {x, y});
            visit[x][y] = true;

            while (!q.isEmpty()){
                int cx = q.peek()[0];
                int cy = q.peek()[1];
                q.poll();
                map[cx][cy] = -2;

                for (int i = 0; i < 4; i++) {
                    int nx = cx + way[i][0];
                    int ny = cy + way[i][1];

                    if (nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny]<0 || visit[nx][ny])
                        continue;
                    if (map[nx][ny]==0 || map[nx][ny]==val) {
                        q.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static boolean com(int cnt, int rain, int x, int y) {
        if(maxCnt != cnt) return maxCnt < cnt;
        if(rainCnt != rain) return rainCnt < rain;
        if(mx != x) return mx < x;
        return my < y;
    }
}