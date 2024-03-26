import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (o1, o2)->o1[0]-o2[0]);

            int ans = 1;
            int min = arr[0][1];
            for (int i = 1; i < n; i++) {
                if (arr[i][1] < min) {
                    ans++;
                    min = arr[i][1];
                }
            }

            System.out.println(ans);
        }
    }
}