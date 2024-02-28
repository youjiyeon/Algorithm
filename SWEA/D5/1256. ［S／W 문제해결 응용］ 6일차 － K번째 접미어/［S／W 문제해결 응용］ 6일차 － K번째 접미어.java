import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            List<String> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine())-1;
            String str = br.readLine();
            int len = str.length();

            for (int i = 0; i < len; i++) {
                list.add(str.substring(i, len));
            }
            Collections.sort(list);

            if (list.size()<=n) {
                sb.append("none").append("\n");
            }
            else
                sb.append(list.get(n)).append("\n");
        }
        System.out.println(sb);
    }
}