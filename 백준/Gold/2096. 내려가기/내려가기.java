import java.io.*;
import java.util.*;

public class Main {
    static int n;
    // 마지막 줄 요소들만 비교하면 되지않을까??
    static int[][] max, min, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1][3];
        max = new int[n+1][3];
        min = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            max[i][0] += Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][0];
            max[i][1] += Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + arr[i][1];
            max[i][2] += Math.max(max[i - 1][1], max[i - 1][2]) + arr[i][2];

            min[i][0] += Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][0];
            min[i][1] += Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + arr[i][1];
            min[i][2] += Math.min(min[i - 1][1], min[i - 1][2]) + arr[i][2];
        }

        int ma = Integer.MIN_VALUE;
        int mi = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ma = Math.max(ma, max[n][i]);
            mi = Math.min(mi, min[n][i]);
        }

        System.out.print(ma+" "+mi);
    }
}