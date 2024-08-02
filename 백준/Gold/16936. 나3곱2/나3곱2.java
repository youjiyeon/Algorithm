import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] arr;
    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            map.put(arr[i], 1);
        }

        for (int i = 0; i < n; i++) {
            map.put(arr[i], 0);
            find(1, arr[i], ""+arr[i]);
            map.put(arr[i], 1);
        }
    }

    static void find(int cnt, long prev, String s) {
        if (cnt == n) {
            for (long i : arr) {
                if (map.get(i) != 0) {
                    return;
                }
            }

            System.out.println(s);
            System.exit(0);
            return;
        }

        if (prev%3 == 0) {
            long tmp = prev/3;
            if (map.containsKey(tmp) && map.get(tmp) != 0) {
                map.put(tmp, 0);
                find(cnt+1, tmp, s+" "+tmp);
                map.put(tmp, 1);
            }
        }

        long tmp = prev*2;
        if (map.containsKey(tmp) && map.get(tmp) != 0) {
            map.put(tmp, 0);
            find(cnt+1, tmp, s+" "+tmp);
            map.put(tmp, 1);
        }

    }
}