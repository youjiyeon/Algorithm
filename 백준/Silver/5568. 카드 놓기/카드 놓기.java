import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static int N, K;
    public static String[] num, pick;
    public static boolean[] visit;
    public static Set<Integer> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        num = new String[N];
        pick = new String[K];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            num[i] = br.readLine();
        }

        per(0);
        System.out.println(set.size());
    }

    private static void per(int cnt) {
        if (cnt == K){
            String str = "";
            for (int i = 0; i < K; i++) {
                str += pick[i];
            }
            set.add(Integer.parseInt(str));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]){
                pick[cnt] = num[i];
                visit[i] = true;
                per(cnt+1);
                visit[i] = false;
            }
        }
    }
}