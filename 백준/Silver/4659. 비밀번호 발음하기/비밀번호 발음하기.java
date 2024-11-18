import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[] gather = {0, 4, 8, 14, 20};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;

            boolean flag = true;

            int[] a = new int[26];
            // a e i o u
            // 0 4 8 14 20

            a[str.charAt(0)-'a']++;
            int g = 0;
            int ng = 0;
            for (int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);
                a[cur-'a']++;

                int tmp = g;
                for (int j = 0; j < 5; j++) {
                    if (cur-'a' == gather[j]) {
                        g++;
                        ng = 0;
                    }
                }
                if (tmp==g) {
                    ng++;
                    g = 0;
                }

                if (g>=3 || ng>=3) {
                    flag = false;
                    break;
                }

                if (i == 0) continue;
                char prev = str.charAt(i-1);
                if (prev == cur) {
                    if (prev == 'e' || prev == 'o') continue;
                    flag = false;
                    break;
                }
            }

            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += a[gather[i]];
            }

            if (sum == 0) {
                flag = false;
            }

            if (flag) {
                sb.append("<").append(str).append(">")
                        .append(" is acceptable.").append("\n");
            }
            else {
                sb.append("<").append(str).append(">")
                        .append(" is not acceptable.").append("\n");
            }
        }

        System.out.print(sb);
    }
}