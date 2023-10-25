import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n==0)
                break;

            int cnt = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if(isPrime(i)){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= (int)Math.sqrt(i); j++) {
            if(i%j==0){
                return false;
            }
        }
        return true;
    }
}