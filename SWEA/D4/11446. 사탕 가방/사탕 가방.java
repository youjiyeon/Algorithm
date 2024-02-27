import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long ans = 0;
            long[] arr = new long[(int) n];

            long s = 1;
            long e = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
                e = Math.max(e, arr[i]);
            }

            long mid = 0;
            while (s<=e) {
                mid = (s+e)/2;

                long cnt = 0;
                for (int i = 0; i < n; i++) {
                    cnt += arr[i]/mid;
                }

                if (cnt<m) e = mid-1;
                else {
                    ans = mid;
                    s = mid+1;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}