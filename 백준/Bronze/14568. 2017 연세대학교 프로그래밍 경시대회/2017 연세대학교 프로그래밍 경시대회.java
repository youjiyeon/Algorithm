import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        // 셋다 0은 안됨
        // 남>=영
        // 택!=홀
        for (int i = 2; i <= n; i+=2) {
            for (int j = 1; j <= n; j++) {
                for (int k = j+2; k <= n; k++) {
                    if (i+j+k==n)
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}