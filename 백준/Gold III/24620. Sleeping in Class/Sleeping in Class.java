import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int T, N;
    private static int[] accumulatedSum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            accumulatedSum = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                accumulatedSum[i] = accumulatedSum[i - 1] + Integer.parseInt(st.nextToken());
            }
            solve();
        }
        System.out.println(sb);
    }
    private static void solve() {
        for (int divisor = N; divisor >= 1; divisor--) {
            if (isSleptEqually(divisor)) {
                sb.append(N - divisor).append("\n");
                return;
            }
        }
    }

    private static boolean isSleptEqually(int divisor) {
        if (accumulatedSum[N] % divisor != 0) return false;
        int start = 0;
        int end;

        for (end = 1; end <= N; end++) {
            if (accumulatedSum[end] - accumulatedSum[start] > accumulatedSum[N]/divisor) return false;
            if (accumulatedSum[end] - accumulatedSum[start] < accumulatedSum[N]/divisor) continue;
            start = end;
        }
        return start == end - 1;
    }
}