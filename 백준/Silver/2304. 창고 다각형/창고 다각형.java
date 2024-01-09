import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int maxIdx = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            map[l] = h;
            start = Math.min(start, l);
            end = Math.max(end, l);
            if (max<h){
                max = h;
                maxIdx = l;
            }
        }

        int cur = map[start];
        int sum = 0;
        for (int i = start; i < maxIdx; i++) {
            if (cur<map[i]){
                cur = map[i];
            }
            sum+=cur;
        }

        cur = map[end];
        for (int i = end; i >= maxIdx; i--) {
            if (cur<map[i]){
                cur = map[i];
            }
            sum+=cur;
        }

        System.out.println(sum);
    }
}