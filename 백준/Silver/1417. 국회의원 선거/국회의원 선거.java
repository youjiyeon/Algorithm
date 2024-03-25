import java.io.*;

public class Main {
    public static int n, maxIdx, max, cnt = 0;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (true) {
            findMax();

            if (maxIdx == 0) {
                break;
            }

            arr[0]++;
            arr[maxIdx]--;

            cnt++;
        }

        System.out.println(cnt);
    }

    public static void findMax() {
        max = 0;
        maxIdx = -1;

        for (int i = 0; i < n; i++) {
            if (max <= arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
        }
    }
}
