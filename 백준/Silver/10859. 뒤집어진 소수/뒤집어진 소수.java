import java.io.*;

public class Main {
    public static int[] turn = {0, 1, 2, -1, -1, 5, 9, -1, 8, 6};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String tmp = "";

        // 입력값이 소수라면
        if(isPrime(Long.parseLong(str))) {
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                if (turn[c - '0'] == -1) {
                    System.out.println("no");
                    System.exit(0);
                }
                tmp += turn[c - '0'];
            }

            System.out.println(isPrime(Long.parseLong(tmp)) ? "yes" : "no");
        }
        else
            System.out.println("no");
    }

    public static boolean isPrime(long n){
        if (n==1)
            return false;

        for (long i = 2; i * i <= n; i++) {
            if (n%i==0)
                return false;
        }
        return true;
    }
}