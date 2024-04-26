import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] color = new int[2];
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map =  new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, n);
        System.out.println(color[0]);
        System.out.println(color[1]);
    }

    public static void recur(int x, int y, int s) {
        //System.out.println(x+" "+y+" "+s);

        int c = map[x][y];
        int i = 0; int j = 0;
        T: for (i = x; i < x+s; i++) {
            for (j = y; j < y+s; j++) {
                if (c != map[i][j]) {
                    break T;
                }
            }
        }

        //System.out.println(i+" "+j);
        if (i==x+s && j==y+s) {
            color[c]++;
        }
        else {
            if (s/2 != 0) {
                recur(x, y, s/2);
                recur(x, y+(s/2), s/2);
                recur(x+(s/2), y, s/2);
                recur(x+(s/2), y+(s/2), s/2);
            }
        }
    }
}