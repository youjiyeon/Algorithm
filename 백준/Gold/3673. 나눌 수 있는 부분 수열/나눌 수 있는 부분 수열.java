import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] c = new int[1000001];

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            Arrays.fill(c, 0);

            st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum+=Integer.parseInt(st.nextToken());
                c[(int)(sum%d)]++;
            }

            long cnt = c[0];
            for (int i = 0; i <= d; i++) {
                long cur = c[i];
                cnt += cur * (cur-1)/2;
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        bw.close();
    }
}