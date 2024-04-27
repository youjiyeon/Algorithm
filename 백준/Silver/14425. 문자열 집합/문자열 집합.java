import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int ans = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            ans += map.getOrDefault(str, 0);
        }

        System.out.println(ans);
    }
}