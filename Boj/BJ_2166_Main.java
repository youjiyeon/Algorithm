import java.io.*;
import java.util.StringTokenizer;

public class BJ_2166_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long x = 0, y = 0;
        int N = Integer.parseInt(br.readLine());
        long[] r = new long[N+1];
        long[] c = new long[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i]= Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        r[N] = 0;
        c[N] = 0;

        for (int i = 0; i < N; i++) {
            x += r[i] * c[i+1];
            y += c[i] * r[i+1];
        }

        String str = String.format("%.1f",(Math.abs(x-y)/2.0));
        bw.write(str);

        br.close();
        bw.flush();
        bw.close();
    }
}
