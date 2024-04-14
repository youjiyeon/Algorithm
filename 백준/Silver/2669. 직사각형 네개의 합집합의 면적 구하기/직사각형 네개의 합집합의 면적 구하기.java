import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int ans = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[101][101];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for (int j = sx; j < ex; j++) {
                for (int k = sy; k < ey; k++) {
                    if (!map[j][k]) {
                        map[j][k] = true;
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}