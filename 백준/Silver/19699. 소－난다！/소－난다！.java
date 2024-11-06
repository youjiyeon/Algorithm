import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] h;
    static boolean[] isPrime = new boolean[9001];
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        h = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        com(0, 0, 0);
        if (set.isEmpty()) {
            System.out.println(-1);
        }
        else {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for (int i : list) {
                System.out.print(i+" ");
            }
        }
    }

    static void com(int cnt, int start, int sum) {
        if (cnt >= m) {
            if (p(sum)) {
                set.add(sum);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            com(cnt+1, i+1, sum+h[i]);
        }
    }

    static boolean p(int sum) {
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= sum; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime[sum];
    }
}