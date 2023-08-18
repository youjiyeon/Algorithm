import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, S;
    public static long[] num;
    public static List<Long> l =  new ArrayList<>();
    public static List<Long> r =  new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        powerSet(0,N/2,0, l);
        powerSet(N/2,N, 0, r);
        Collections.sort(l);
        Collections.sort(r);

        int pl = 0;
        int pr = r.size()-1;
        long cnt = 0;

        while (pl<l.size() && pr>=0){
            long sum = l.get(pl) + r.get(pr);

            if (sum==S){
                long a = l.get(pl);
                long tempA = 0;
                while (pl<l.size() && l.get(pl)==a){
                    pl++;
                    tempA++;
                }

                long b = r.get(pr);
                long tempB = 0;
                while (pr>=0 && r.get(pr)==b){
                    pr--;
                    tempB++;
                }

                cnt += tempA*tempB;
            }
            else if (sum < S) {
                pl++;
            }
            else {
                pr--;
            }
        }

        if (S==0)
            cnt--;
        System.out.println(cnt);
    }

    static void powerSet(int idx, int end, long val, List<Long> list) {
        if(idx == end)
        {
            list.add(val);
            return;
        }

        powerSet(idx+1, end, val+num[idx], list);
        powerSet(idx+1, end, val, list);
    }
}
