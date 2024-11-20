import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a==b) {
            System.out.println(0);
            System.exit(0);
        }

        int tmp1 = a;
        int tmp2 = b;
        a = Math.min(tmp1, tmp2);
        b = Math.max(tmp1, tmp2);

        System.out.println(b-a-1);
        for (int i = a+1; i < b; i++) {
            System.out.print(i+" ");
        }
    }
}