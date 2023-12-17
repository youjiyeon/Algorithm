import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 변화하는 칸에 대응
        m = n;

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (m!=1){
            for (int r = 0; r < m; r+=2) {
                for (int c = 0; c < m; c+=2) {
                    List<Integer> list = new ArrayList<>();
                    for (int i = r; i < r+2; i++) {
                        for (int j = c; j < c+2; j++) {
                            list.add(map[i][j]);
                        }
                    }
                    Collections.sort(list);
                    Collections.reverse(list);
                    map[r/2][c/2] = list.get(1);
                }
            }

            m/=2;
        }
        System.out.println(map[0][0]);
    }
}