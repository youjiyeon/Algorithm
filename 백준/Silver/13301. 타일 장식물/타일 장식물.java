// 둘레.. 이거 어렵네
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        dp = new int[input+1];
        dp[0] = 1;
        dp[1] = 1;

/*        for (int i = 2; i < input; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }*/
        fibo(input);

        System.out.println((2*(dp[input]))+(2*(dp[input-1])));
    }

    public static int fibo(int a) {
        if (a <= 1)
            return 1;
        if (dp[a] != 0)
            return dp[a];
        else {
            dp[a] = fibo(a - 1) + fibo(a - 2);
            return dp[a];
        }

    }
}
