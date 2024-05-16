import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '.') {
                sb.append('.');
                continue;
            }

            int l = 0;
            while (str.charAt(i) != '.') {
                l++;
                i++;

                if (i>=len) break;
            }

            i--;
            if (l % 2 != 0) {
                flag = false;
                System.out.println(-1);
                break;
            }

            if (l / 4 != 0) {
                for (int j = 0; j < l / 4; j++) {
                    sb.append("AAAA");
                }
                l %= 4;
            }
            if (l / 2 != 0) {
                for (int j = 0; j < l / 2; j++) {
                    sb.append("BB");
                }
            }
        }

        // 변환 가능하다면
        if (flag) {
            System.out.println(sb);
        }
    }
}