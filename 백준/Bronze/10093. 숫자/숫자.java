import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (a==b) {
            System.out.println(0);
            System.exit(0);
        }

        long tmp1 = a;
        long tmp2 = b;
        a = Math.min(tmp1, tmp2);
        b = Math.max(tmp1, tmp2);

        System.out.println(b-a-1);
        for (long i = a+1; i < b; i++) {
            System.out.print(i+" ");
        }
    }
}