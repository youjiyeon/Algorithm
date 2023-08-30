import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C, cheese;
    static int[][] map;
    static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean[][] visited;
    static List<Point> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cheese = 0;
        map = new int[R][C];
        list = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) {
                    list.add(new Point(r, c));
                    cheese++;
                }
            }
        }

        int time = 0;
        while (cheese != 0) {
            time++;
            visited = new boolean[R][C];
            dfs(0, 0);
            melting();
        }
        System.out.println(time);
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;
        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + way[i][0];
            int ny = y + way[i][1];
            
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (visited[nx][ny] || map[nx][ny] == 1) continue; // 외내부 공기 판별을 위해 치즈인 경우도 pass 
            
            dfs(nx, ny);
        
        }
    }

    static void melting() {
        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            int cnt = 0;

            for(int j = 0; j < 4; j++) {
                int nx = x +way[j][0];
                int ny = y + way[j][1];

                if(map[nx][ny] == 2) {
                    cnt++;
                }
            }

            if(cnt >= 2) { // 외부 공기와 2변 이상 접촉한 경우
                map[x][y] = 0;
                cheese--;
                list.remove(i);
                i--;
            }
        }
    }
    private static boolean isRight(int nx, int ny) {
        if (nx >= 0 && nx < R && ny >= 0 && ny < C)
            return true;
        return false;
    }

}