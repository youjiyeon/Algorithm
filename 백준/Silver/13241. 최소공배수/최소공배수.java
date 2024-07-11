import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = getGCD(Math.max(a, b), Math.min(a, b));

        System.out.println((a*b)/gcd);
    }

    static long getGCD(long a, long b) {
        while(b > 0) {
            long tmp = a;
            a = b;
            b = tmp%b;
        }
        
        return a;
    }
}
