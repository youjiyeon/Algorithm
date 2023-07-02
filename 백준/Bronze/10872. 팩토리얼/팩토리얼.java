import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N != 0) {
            factorial(N);
        }
        System.out.println(result);
    }

    private static void factorial(int n) {
        if(n<=1){
            return;
        }
        result*=n;
        factorial(n-1);
    }
}