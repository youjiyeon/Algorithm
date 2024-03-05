import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n+1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            map.put(str, i);
            arr[i] = str;
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            // int라면
            if (isInteger(str)) {
                sb.append(arr[Integer.parseInt(str)]).append("\n");
            }
            else {
                sb.append(map.get(str)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}