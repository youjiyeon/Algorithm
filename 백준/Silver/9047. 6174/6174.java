import java.io.*;
import java.util.Arrays;
import java.util.Collections;

class Main {
    static Integer[] arr = new Integer[4];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }

            int tmp = change(arr);
            int cnt = 0;

            while (tmp != 6174) {
                Arrays.sort(arr);
                int min = change(arr);
                
                Arrays.sort(arr, Collections.reverseOrder());
                int max = change(arr);

                tmp = max - min;
                re(tmp);
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static int change(Integer[] arr) {
        int res = arr[3];
        int tmp = 10;
        for (int i = 2; i >= 0; i--) {
            res += arr[i]*tmp;
            tmp*=10;
        }

        return res;
    }
    static void re(int val) {
        for (int i = 3; i >= 0; i--) {
            arr[i] = val%10;
            val/=10;
        }
    }
}