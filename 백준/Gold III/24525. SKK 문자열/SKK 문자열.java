import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1_000_000;
    static int[] arr;
    static int SIZE = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = new int[str.length() + 1];
        int[] sCount = new int[100001];
        int[] kCount = new int[100001];
        int[] min = new int[300010];
        Arrays.fill(min, MOD);
        min[SIZE] = 0;
        for (int i = 1; i <= str.length(); i++) {
            arr[i] = arr[i - 1];
            sCount[i] = sCount[i - 1];
            kCount[i] = kCount[i - 1];
            if (str.charAt(i - 1) == 'S') {
                arr[i] += 2;
                sCount[i]++;
            }
            if (str.charAt(i - 1) == 'K') {
                arr[i] -= 1;
                kCount[i]++;
            }
            min[SIZE + arr[i]] = Math.min(min[SIZE + arr[i]], i);
        }
        int result = -1;

        for (int i = 1; i <= str.length(); i++) {
            int left = min[SIZE + arr[i]];
            int size = i - left;
            int k = kCount[i] - kCount[left];
            int s = sCount[i] - sCount[left];
            if (k != 0 && s != 0) {
                result = Math.max(result, size);
            }
        }
        System.out.println(result);
    }
}