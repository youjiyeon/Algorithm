import java.io.*;
import java.util.*;

public class Main {
    static int n, s_len;
    static int[] l;
    static String s;
    static String[] a;
    static boolean[] dp; // 각 위치에서 만들 수 있는지 여부를 저장하는 DP 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        s_len = s.length();

        n = Integer.parseInt(br.readLine());

        a = new String[n];
        l = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
            l[i] = a[i].length();
        }

        dp = new boolean[s_len + 1];
        dp[0] = true; // 시작 위치는 항상 true

        for (int i = 0; i < s_len; i++) {
            if (!dp[i]) continue; // 현재 위치에서 만들 수 없으면 넘어감

            for (int j = 0; j < n; j++) {
                int len = l[j];
                if (i + len <= s_len && s.startsWith(a[j], i)) {
                    dp[i + len] = true; // a[j]로부터 만들어진다면 해당 위치를 true로 설정
                }
            }
        }

        System.out.println(dp[s_len] ? 1 : 0);
    }
}