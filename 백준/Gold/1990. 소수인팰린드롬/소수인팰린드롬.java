import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] prime = new boolean[100000001];
    public static void main(String[] args)throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 에라토스테네스의 체, DP
        // 소수인지 아닌지를 미리 저장
        initPrime();

        // 팰린드롬
        for (int i = a; i <= b; i++) {
            if (!prime[i] && palindrome(i)){
                sb.append(i).append("\n");
            }
        }
        sb.append(-1).append("\n");
        System.out.println(sb);
    }

    private static boolean palindrome(int n) {
        String str = String.valueOf(n);
        int N = str.length();
        if (N==1)
            return true;

        for (int i = 0; i < N/2; i++) {
            if (str.charAt(i) != str.charAt(N-i-1))
                return false;
        }

        return true;
    }

    private static void initPrime() {
        for (int i = 2; i*i <= 100000000; i++) {
            if (prime[i]) continue;
            for (int j = i*i; j <= 100000000; j+=i) {
                prime[j] = true;
            }
        }
    }
}