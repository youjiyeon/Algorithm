import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static char[][] map;
    public static Stack<int[]> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j]=='o'){
                    s.push(new int[] {i,j});
                }
            }
        }

        while (!s.isEmpty()){
            int x = s.peek()[0];
            int y = s.peek()[1];
            s.pop();

            int i = 0;
            for (i = x+1; i < n; i++) {
                if (map[i][y]=='#' || map[i][y]=='o'){
                    map[x][y] = '.';
                    map[i-1][y] = 'o';
                    break;
                }
            }
            if (i==n){
                map[x][y] = '.';
                map[n-1][y] = 'o';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}