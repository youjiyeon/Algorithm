import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        long ans = 0L;
        long[] cnt = new long[3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            switch (c){
                case 'W':
                    cnt[0]++;
                    cnt[0] %= 1_000_000_007;
                    break;
                case 'H':
                    cnt[1] += cnt[0];
                    cnt[1] %= 1_000_000_007;
                    break;
                case 'E':
                    ans += cnt[2];
                    ans %= 1_000_000_007;
                    cnt[2] += cnt[2];
                    cnt[2] += cnt[1];
                    cnt[2] %= 1_000_000_007;
                    break;
            }
        }
        System.out.println(ans);
    }
}