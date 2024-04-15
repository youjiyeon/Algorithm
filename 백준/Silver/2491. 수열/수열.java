import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int cnt_b = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int in = Integer.parseInt(st.nextToken());
            if (cur<in) {
                cnt++;
                cnt_b = 1;
            }
            else if (cur>in) {
                cnt_b++;
                cnt = 1;
            }
            else {
                cnt++;
                cnt_b++;
            }

            cur = in;
            max = Math.max(max, cnt_b);
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}