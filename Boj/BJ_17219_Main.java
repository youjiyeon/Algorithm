import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_17219_Main {
    public static Map<String, String> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        map = new HashMap<String, String>();
        int T = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 입력
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String domain = st.nextToken();
            String password = st.nextToken();

            map.put(domain,password);
        }
        //

        // 동작
        for (int i = 0; i < t; i++) {
            String domain = br.readLine();
            sb.append(map.get(domain)+"\n");
        }
        //

        System.out.println(sb);
    }
}
