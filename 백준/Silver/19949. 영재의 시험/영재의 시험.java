import java.io.*;
import java.util.*;

public class Main {
    public static int n = 10, answer = 0;
    public static int[] ans = new int[n], pick = new int[n];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        com(0, 0);
        System.out.println(answer);
    }

    public static void com(int cnt, int sum) {
        if (cnt==n) {
            if (sum>=5) answer++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (cnt>1){
                if (pick[cnt-1]==i && pick[cnt-2]==i)
                    continue;
            }

            pick[cnt] = i;
            if (ans[cnt]==pick[cnt]) {
                com(cnt+1, sum+1);
            }
            else com(cnt+1, sum);
        }
    }
}