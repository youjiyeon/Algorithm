import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] turn = {0, 1, 2, -1, -1, 5, 9, -1, 8, 6};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcd = Integer.parseInt(st.nextToken());
        long mul = (long) gcd*lcd;

        int a = 0, b = 0;
        for (int i = gcd; i <= (int) Math.sqrt(mul); i+=gcd) {
            if (mul%i==0 && GCD(i, mul/i)==gcd){
                a=i;
                b = (int) (mul/i);
            }
        }
        System.out.println(a+" "+b);
    }

    private static long GCD(long a, long b) {
        while(b != 0){
            long tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}