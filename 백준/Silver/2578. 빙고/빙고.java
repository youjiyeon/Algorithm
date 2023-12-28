import java.io.*;
import java.util.*;

public class Main {
    public static int n, cnt;
    public static int[][] map;
    public static boolean[] x, y, c;
    public static void main(String[] args) throws IOException {
        n = 5;
        map = new int[n][n];
        x = new boolean[n];
        y = new boolean[n];
        c = new boolean[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                int val = Integer.parseInt(st.nextToken());

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (map[j][k]==val){
                            map[j][k]=0;

                            // x
                            int l = 0;
                            for (l = 0; l < n; l++) {
                                if (map[j][l]!=0)
                                    break;
                            }
                            if (!x[j] && l==n){
                                cnt++;
                                x[j] = true;
                            }
                            // y
                            for (l = 0; l < n; l++) {
                                if (map[l][k]!=0)
                                    break;
                            }
                            if (!y[k] && l==n){
                                cnt++;
                                y[k] = true;
                            }
                            // 대각선
                            for (l = 0; l < n; l++) {
                                if (map[l][l]!=0){
                                    break;
                                }
                            }
                            if (!c[0] && l==n){
                                cnt++;
                                c[0] = true;
                            }

                            for (l = 0; l < n; l++) {
                                if (map[l][(n-1)-l]!=0){
                                    break;
                                }
                            }
                            if (!c[1] && l==n){
                                cnt++;
                                c[1] = true;
                            }

                            if (cnt>=3){
                                System.out.println((n*i)+(ii+1));
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
    }
}