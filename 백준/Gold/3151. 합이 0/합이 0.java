import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long ans = 0;
    public static int[] students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        students = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                // 이분탐색
                int tmp = -1 * (students[i] + students[j]);

                int ul = j+1;
                int ur = n;
                int um  = (ul+ur)/2;

                while (ul<ur) {
                    um  = (ul+ur)/2;
                    if (tmp >= students[um]) {
                        ul = um+1;
                    }
                    else {
                        ur = um;
                    }
                }

                int ll = j+1;
                int lr = n;
                int lm  = (ll+lr)/2;

                while (ll<lr) {
                    lm  = (ll+lr)/2;
                    if (tmp > students[lm]) {
                        ll = lm+1;
                    }
                    else {
                        lr = lm;
                    }
                }

                ans += ul - ll;
            }
        }
        System.out.println(ans);
    }
}