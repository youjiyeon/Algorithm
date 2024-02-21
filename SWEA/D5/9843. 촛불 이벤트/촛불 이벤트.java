import java.io.*;

public class Solution {
    public static long n;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            n = Long.parseLong(br.readLine());
            long cnt = (long) Math.sqrt(n*2);
            if (cnt*(cnt+1)!=n*2) cnt = -1;

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}