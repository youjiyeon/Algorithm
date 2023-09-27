import java.io.*;
import java.util.*;

public class Main
{
    public static int n, total, min = Integer.MAX_VALUE;
    public static int[][] map, mark,
    way = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int[] town;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        mark = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        solve();
        System.out.println(min);
    }

    public static void solve(){
        // x, y 돌리기
        for (int x = 0; x <= n-3 ; x++) {
            for (int y = 1; y <= n-2; y++) {
                // d1, d2 경계값안에서 돌리기
                for (int d1 = 1; x+d1 <= n-2 && y-d1 >= 0; d1++) {
                    for (int d2 = 1; x+d1+d2 < n && y+d2 < n; d2++) {
                        // 구간 저장 배열 초기화
                        for (int i = 0; i < n; i++) {
                            Arrays.fill(mark[i], 0);
                        }

                        // 5구간 marking
                        for (int i = 0; i <= d1; i++) {
                            mark[x+i][y-i] = 5;
                            mark[x+d2+i][y+d2-i] = 5;
                        }
                        for (int i = 0; i <= d2; i++) {
                            mark[x+i][y+i] = 5;
                            mark[x+d1+i][y-d1+i] = 5;
                        }

                        // 경계선 값 설정
                        for (int r = x-1; r >= 0; r--) {
                            mark[r][y] = 1;
                        }
                        for (int c = y+d2+1; c < n; c++) {
                            mark[x+d2][c] = 2;
                        }
                        for (int c = y-d1-1; c >= 0; c--) {
                            mark[x+d1][c] = 3;
                        }
                        for (int r = x+d1+d2+1; r < n; r++) {
                            mark[r][y-d1+d2] = 4;
                        }

                        // 각 모서리에서 marking
                        marking(0,0,1);
                        marking(0,n-1,2);
                        marking(n-1,0,3);
                        marking(n-1,n-1,4);

                        town = new int[6];
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                town[mark[i][j]] += map[i][j];
                            }
                        }
                        town[5] += town[0];
                        town[0] = 0;
                        Arrays.sort(town);

                        if (town[1]!=0) {
                            min = Math.min(min, (town[5] - town[1]));
                        }
                    }
                }
            }
        }
    }
    public static void marking(int r, int c, int value){
        if (r<0 || r>=n || c<0 || c>=n || mark[r][c]!=0) {
            return;
        }
        mark[r][c] = value;

        for (int i = 0; i < 4; i++) {
            int nr = r + way[i][0];
            int nc = c + way[i][1];
            marking(nr,nc,value);
        }
    }
}