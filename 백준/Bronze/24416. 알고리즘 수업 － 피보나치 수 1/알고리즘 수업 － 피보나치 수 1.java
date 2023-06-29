import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        f = new int[n+1];
        f[1] = 1; f[2] = 1;

        System.out.println(fib(n)+" "+(n-2));
    }

    public static int fib(int n){
        if(n==1 || n==2){
            return 1;
        }
        else{
            return (fib(n-1)+fib(n-2));
        }
    }

    public static int fibonacci(int n){
        for (int i = 3; i <= n; i++) {
            f[i] = f[i-1]+f[i-2];
        }
        return f[n];
    }

}