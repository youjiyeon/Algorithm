import java.io.*;
import java.util.*;

public class Main {
    static int sx, sy;
    static int kx, ky;
    static int[][] way = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String k = st.nextToken();
        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        sy = s.charAt(0)-'A';
        sx = 8 - (s.charAt(1)-'0');
        ky = k.charAt(0)-'A';
        kx = 8 - (k.charAt(1)-'0');

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int nx = kx;
            int ny = ky;
            int type = 0;
            boolean same = true;
            if (str.equals("R")) {
                type = 0;
            }
            else if (str.equals("L")) {
                type = 1;
            }
            else if (str.equals("B")) {
                type = 2;
            }
            else if (str.equals("T")) {
                type = 3;
            }
            else if (str.equals("RT")) {
                type = 4;
            }
            else if (str.equals("LT")) {
                type = 5;
            }
            else if (str.equals("RB")) {
                type = 6;
            }
            else if (str.equals("LB")) {
                type = 7;
            }

            nx += way[type][0];
            ny += way[type][1];
            if (nx<0 || nx>=8 || ny<0 || ny>=8) continue;
            if (nx==sx && ny==sy) {
                int tx = sx + way[type][0];
                int ty = sy + way[type][1];

                if (tx<0 || tx>=8 || ty<0 || ty>=8) {
                    same = false;
                }
                else {
                    sx = tx; sy = ty;
                }
            }
            if (same) {
                kx = nx; ky = ny;
            }
        }

        char sc = (char) (sy + 'A');
        char kc = (char) (ky + 'A');

        System.out.println(kc+""+(8-kx));
        System.out.println(sc+""+(8-sx));
    }
}