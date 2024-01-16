import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(cal(b)-cal(a-1));
    }

    private static long cal(long n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        if (n%2==0)
            return n/2+2*cal(n/2);
        if (n%2!=0)
            return n/2+2*cal(n/2)+1;
        return n;
    }
}