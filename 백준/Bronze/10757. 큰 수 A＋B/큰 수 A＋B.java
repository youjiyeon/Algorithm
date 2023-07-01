import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String[] arr1 = st.nextToken().split("");
        String[] arr2 = st.nextToken().split("");

        br.close();

        List<String> list1 = Arrays.asList(arr1);
        List<String> list2 = Arrays.asList(arr2);

        Collections.reverse(list1);
        Collections.reverse(list2);

        String[] max, min;

        if (arr1.length > arr2.length) {
            max = list1.toArray(arr1);
            min = list2.toArray(arr2);
        } else {
            max = list2.toArray(arr2);
            min = list1.toArray(arr1);
        }

        StringBuilder sb = new StringBuilder();

        int[] sum = new int[max.length];

        for (int i = max.length - 1; i >= 0; i--) {

            if (i > min.length - 1) {
                sum[i] = Integer.parseInt(max[i]);
            } else {

                sum[i] = Integer.parseInt(max[i]) + Integer.parseInt(min[i]);
            }

        }

        for (int i = 0; i < sum.length - 1; i++) {

            if (sum[i] >= 10) {
                sum[i] = sum[i] % 10;
                sum[i + 1] = sum[i + 1] + 1;

            }

        }

        for (int i = max.length - 1; i >= 0; i--) {
            sb.append(sum[i]);
        }

        System.out.println(sb);
    }
}