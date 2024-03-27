import java.io.*;
import java.util.*;

public class Main {
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];

        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, rope[i]*(n-i));
        }

        System.out.println(ans);
    }
}