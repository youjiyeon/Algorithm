import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, max = Integer.MIN_VALUE;
    public static char[][] map, copy;
    public static boolean[][] v;
    public static int[][] pick,
            way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        pick = new int[2][2];
        v = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            checkMax(i, 0,0);
            checkMax(i, 1,0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                combi(i, j, 0);
            }
        }
        System.out.println(max);
    }

    private static void combi(int x, int y, int cnt) {
        if (max==n)
            return;

        if (cnt==2){
            copy = new char[n][n];
            for (int i = 0; i < n; i++) {
                copy[i] = map[i].clone();
            }
            copy[pick[1][0]][pick[1][1]] = map[pick[0][0]][pick[0][1]];
            copy[pick[0][0]][pick[0][1]] = map[pick[1][0]][pick[1][1]];

            checkMax(pick[0][0], 0,1);
            checkMax(pick[1][0], 0,1);
            checkMax(pick[0][1], 1,1);
            checkMax(pick[1][1], 1,1);

            //System.out.println();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + way[i][0];
            int ny = y + way[i][1];

            if (nx<0 || nx>= n || ny<0 || ny>=n)
                continue;
            if (map[x][y]!=map[nx][ny]){
                pick[cnt][0] = nx;
                pick[cnt][1] = ny;
                combi(nx,ny, cnt+1);
            }
        }
    }

    public static void checkMax(int i, int type, int arr) {
        int cnt = 1;
        if (arr == 0) {
            if (type == 0) {
                for (int k = 0; k < n - 1; k++) {
                    if (map[i][k] == map[i][k + 1]) {
                        cnt++;
                        max = Math.max(max, cnt);
                    } else cnt = 1;
                }
            } else {
                for (int k = 0; k < n - 1; k++) {
                    if (map[k][i] == map[k + 1][i]) {
                        cnt++;
                        max = Math.max(max, cnt);
                    } else cnt = 1;
                }
            }
        }
        if (arr == 1) {
            if (type == 0) {
                for (int k = 0; k < n - 1; k++) {
                    if (copy[i][k] == copy[i][k + 1]) {
                        cnt++;
                        max = Math.max(max, cnt);
                    } else cnt = 1;
                }
            } else {
                for (int k = 0; k < n - 1; k++) {
                    if (copy[k][i] == copy[k + 1][i]) {
                        cnt++;
                        max = Math.max(max, cnt);
                    } else cnt = 1;
                }
            }
        }
    }
}