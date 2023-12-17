import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, len;
    public static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        len = Math.min(n, m);
        T: while (len>1){
            // 각 자리마다
            for (int i = 0; i <= n-len; i++) {
                for (int j = 0; j <= m-len; j++) {
                    // 해당 값
                    int val = map[i][j];
                    if (val==map[i][j+len-1] && val==map[i+len-1][j]
                            && val==map[i+len-1][j+len-1]){
                        break T;
                    }
                }
            }
            len--;
        }
        System.out.println(len*len);
    }
}