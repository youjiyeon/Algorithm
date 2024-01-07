import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean[] num = new boolean[1000001];
    public static List<Long> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        makePrime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());
            if (isPass(n)){
                sb.append("YES").append("\n");
            }
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    private static void makePrime() {
        for(long i = 2; i <= 1000000; i++){
            if(num[(int) i]) continue;
            for(long j = i + i; j <= i; j += i){
                num[(int) j] = true;
            }
        }
        for(long i = 2; i <= 1000000; i++){
            if(!num[(int) i]) prime.add(i);
        }
    }

    public static boolean isPass(long n){
        for (long p: prime) {
            if (n%p == 0) return false;
        }
        return true;
    }
}