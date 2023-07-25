import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        BigInteger B = BigInteger.valueOf(Integer.parseInt(st.nextToken()));

        System.out.println(A.add(B));
    }
}