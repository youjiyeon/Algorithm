import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] map = new int[500010];
        int[] sum = new int[500010];
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            // 짝수면
            if (i%2==0){
                map[1]++;
                map[x+1]--;
            }
            else {
                map[H-x+1]++;
            }
        }

        for (int i = 1; i <= H; i++) {
            sum[i] = sum[i-1]+map[i];
        }

        int tmp = Integer.MAX_VALUE;
        for (int i = 1; i <= H; i++) {
            tmp = Math.min(tmp, sum[i]);
        }

        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            if (sum[i]==tmp) cnt++;
        }
        bw.write(tmp+" "+cnt);
        bw.flush();
        bw.close();
    }
}