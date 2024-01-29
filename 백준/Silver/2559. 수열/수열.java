import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        int[] sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            if (i+k<=n){
                max = Math.max(max, sum[i+k]-sum[i]);
            }
        }
        System.out.println(max);
    }
}