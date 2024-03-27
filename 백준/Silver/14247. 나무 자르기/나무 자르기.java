import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tree = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree, (o1, o2)->o1[1]-o2[1]);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((long) tree[i][1] *i)+tree[i][0];
        }

        System.out.println(ans);
    }
}