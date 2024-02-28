import java.io.*;
import java.util.*;
public class Solution {
    static int[] map;
    static int n, m, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            cnt = 0;
            
            Map<String, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                map.put(st.nextToken(), 1);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                String str = st.nextToken();
                if (map.containsKey(str)) {
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}