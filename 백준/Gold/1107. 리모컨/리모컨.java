import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        if (m!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(n - 100);
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean flag = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                int min = Math.abs(n - i) + len;
                ans = Math.min(min, ans);
            }
        }
        System.out.println(ans);
    }
}