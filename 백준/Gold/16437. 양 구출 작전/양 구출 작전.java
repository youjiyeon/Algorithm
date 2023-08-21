import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Integer>[] list;
    public static long[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        result = new long[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            long n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[t].add(i);
            if (c=='W'){
                n *= -1;
            }
            result[i] = n;
        }

        dfs(1,-1);
        System.out.println(result[1]);
    }

    public static void dfs(int idx, int pa){
        for (int nxt: list[idx]) {
            dfs(nxt, idx);
        }

        if (pa != -1){
            if (result[idx]>0){
                result[pa] += result[idx];
            }
        }
    }
}
