import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(binomial(n, r));
    }
    public static int binomial(int n, int r) {
        if(r == 0 || n == r)
            return 1;
        return binomial(n - 1, r - 1) + binomial(n - 1, r);
    }
}