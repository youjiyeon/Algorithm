import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;
        boolean flag = false;

        for (int i = m; i <= n; i++) {
            if(isPrime(i)){
                sum+=i;
                if(!flag){
                    min = i;
                    flag = true;
                }
            }
        }
        if (sum==0){
            System.out.println(-1);
        }
        else
            System.out.println(sum+"\n"+min);
    }

    public static boolean isPrime(int n) {
        if(n==1)
            return false;
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}