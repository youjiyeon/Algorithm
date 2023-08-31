import java.util.*;
import java.io.*;
 
public class Main {
    static final int APPLE = 5, SNAKE = 1;
    static int N, K, L, time;
    static int[][] map;
    static int[][] order;
    static int[] pos_x = { 0, -1, 0, 1 };
    static int[] pos_y = { 1, 0, -1, 0 };
    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(time);
    }
 
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = APPLE;
        }
 
        L = Integer.parseInt(br.readLine());
        order = new int[L + 2][2];
        for (int i = 1; i <= L; i++) {
            st = new StringTokenizer(br.readLine());
 
            int x = Integer.parseInt(st.nextToken());
            int d = 0;
            char temp = st.nextToken().charAt(0);
            if (temp == 'L') d = 0;
            else d = 1;
 
            order[i][0] = x; 
            order[i][1] = d; 
        }
 
        br.close();
    }
 
    public static void solve() {
        int idx = 1;
        Deque<Snake> snake = new LinkedList<>();
 
        snake.add(new Snake(1, 1, 0));
        map[1][1] = SNAKE;
        outer:
            while (true) {
                int px = snake.peekLast().x;
                int py = snake.peekLast().y;
                int d = snake.peekLast().d;
                int nx, ny;
 
                nx = px + pos_x[d];
                ny = py + pos_y[d];
 
                time++;
                if (!isIn(nx, ny)) break outer;
                if (map[nx][ny] == 0) {
                    int lx = snake.peek().x;
                    int ly = snake.peek().y;
                    map[lx][ly] = 0;
                    snake.poll();
                }
                map[nx][ny] = SNAKE;
                snake.add(new Snake(nx, ny, d));
                px = nx;
                py = ny;
 
                if (order[idx][0] == time)
                    snake.peekLast().d = getDirection(snake.peekLast().d, order[idx++][1]);
            }
    }
 
    public static boolean isIn(int x, int y) {
        if (x < 1 || x > N || y < 1 || y > N || map[x][y] == SNAKE)
            return false;
 
        return true;
    }
 
    public static int getDirection(int prev, int d) {
        int next = 0;
 
        switch(prev) {
        case 0:
            if (d == 0) next = 1;
            else next = 3;
            break;
        case 1:
            if (d == 0) next = 2;
            else next = 0;
            break;
        case 2:
            if (d == 0) next = 3;
            else next = 1;
            break;
        case 3:
            if (d == 0) next = 0;
            else next = 2;
            break;
        }
 
        return next;
    }
 
    static class Snake {
        int x;
        int y;
        int d;
 
        public Snake(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}