import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] has = new boolean[1000001];
        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            if (!has[arr[i]])
                has[arr[i]] = true;
        }

        for (int i = 0; i <= max; i++) {
            if (has[i]) {
                int cnt = 1;
                int cur = -1;
                for (int j = 0; j < n; j++) {
                    if (arr[j] == i) continue;
                    if (cur != arr[j]) {
                        cnt = 1;
                    }
                    else {
                        cnt++;
                    }
                    ans = Math.max(ans, cnt);
                    cur = arr[j];
                }
            }
        }

        System.out.println(ans);
    }
}