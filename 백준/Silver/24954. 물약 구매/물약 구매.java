import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] choice, potion;
    static List<int[]>[] discountList;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        potion = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            potion[i] = Integer.parseInt(st.nextToken());

        discountList = new ArrayList[N];
        for (int i = 0; i < N; i++)
            discountList[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int P = Integer.parseInt(br.readLine());
            for (int j = 0; j < P; j++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken())-1;
                int discount = Integer.parseInt(st.nextToken());
                discountList[i].add(new int[]{idx, discount});
            }
        }

        v = new boolean[N];
        choice = new int[N];
        ans = Integer.MAX_VALUE;

        perm(0, 0);

        System.out.println(ans);
    }

    public static void perm(int cnt, int sum) {
        if(cnt == N){
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = 0; i < N; i ++){
            if(v[i]) continue;
            choice[cnt] = i;

            int curCost = potion[i];

            v[i] = true;
            cal(i, 0);

            perm(cnt+1, sum + (curCost <= 0 ? 1 : curCost));

            v[i] = false;
            cal(i, 1);
        }
    }

    public static void cal(int i, int type) {
        for(int[] cur: discountList[i]){
            if(type == 0)
                potion[cur[0]]-=cur[1];
            else
                potion[cur[0]]+=cur[1];
        }
    }
}