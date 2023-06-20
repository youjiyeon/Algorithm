import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629_Main {
    public static long[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new long[3];
        for (int i = 0; i < 3; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }
        /*long total = num[0];
        for (int i = 0; i < num[1]; i++) {
            total *= num[0];
        }*/

        System.out.println(pow(num[0], num[1]));
    }
    public static long pow(long A, long exponent){
        if(exponent==1)
        {
            return A%num[2];
        }
        long temp = pow(A, exponent/2);
        if (exponent%2==1){
            return (temp*temp%num[2])*A%num[2];
        }
        return temp*temp%num[2];
    }
}
