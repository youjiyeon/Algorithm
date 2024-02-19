import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int x;
        int y;
        int v;
        public Node(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    public static int n, m, size, ans = Integer.MAX_VALUE;
    public static int[] pick;
    public static int[][] map, copy, w = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };;
    public static int[][][] way = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 1 }, { 2, 3 } },
            { { 0, 2 }, { 0, 3 }, { 1, 3 }, { 1, 2 } }, { { 0, 1, 2 }, { 0, 2, 3 }, { 0, 1, 3 }, { 1, 2, 3 } },
            { { 0, 1, 2, 3 } } };
    public static List<Node> cctv = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                copy[i][j] = tmp;
                if (tmp>=1 && tmp<=5){
                    cctv.add(new Node(i,j,tmp));
                }
            }
        }

        size = cctv.size();
        pick = new int[size];

        perm(0);
        System.out.println(ans);
    }

    public static void perm(int cnt){
        if (cnt==size){
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = copy[i].clone();
            }

            play();

            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j]==0)
                        sum++;
                }
            }

            ans = Math.min(ans, sum);
            return;
        }

        // 각 cctv의 방향 고르기
        for (int i = 0; i < way[cctv.get(cnt).v].length; i++) {
            pick[cnt] = i;
            perm(cnt+1);
        }
    }

    public static void play(){
        for (int i = 0; i < size; i++) {
            Node cur = cctv.get(i);

            int v = cur.v;
            for (int j:way[v][pick[i]]) {
                int x = cur.x;
                int y = cur.y;

                while (true){
                    x+=w[j][0];
                    y+=w[j][1];

                    if (x<0 || x>=n || y<0 || y>=m || map[x][y]==6)
                        break;
                    map[x][y] = -1;
                }
            }
        }
    }
}