import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int len = str.length();
            String[] arr = new String[len];
            int[] lcp = new int[len];

            for (int i = 0; i < len; i++) {
                arr[i] = str.substring(i, len);
            }
            Arrays.sort(arr);

            for (int i = 1; i < len; i++) {
                lcp[i] = getLCP(arr[i-1], arr[i]);
            }

            int cnt = 0;
            for (int i = 0; i < len; i++) {
                cnt += arr[i].length() - lcp[i];

                if (cnt>=n) {
                    String ans = arr[i].substring(0, arr[i].length()-(cnt-n));
                    sb.append(ans).append("\n");
                    break;
                }
            }
            if (cnt<n) {
                sb.append("none").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int getLCP(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
            cnt++;
        }

        return cnt;
    }
}