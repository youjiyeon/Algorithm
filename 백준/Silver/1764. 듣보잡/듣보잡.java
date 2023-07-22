import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (map.containsKey(str)){
                list.add(str);
            }
        }

        // 키 값으로 오름차순 정렬
        Collections.sort(list);
        sb.append(list.size()+"\n");
        for (String s : list) {
            sb.append(s+"\n");
        }

        System.out.println(sb);
    }
}