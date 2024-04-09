import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int len = tmp.length();

        if (len == 1) {
            System.out.println("NO");
            System.exit(0);
        }

        int[] arr  = new int[len];
        int s = 1, e = 1;
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(String.valueOf(tmp.charAt(i)));
        }

        for (int i = 0; i < len; i++) {
            s *= arr[i];

            e = 1;
            for (int j = i+1; j < len; j++) {
                e *= arr[j];
            }

            if (s == e) {
                System.out.println("YES");
                System.exit(0);
            }
        }

        System.out.println("NO");
    }
}