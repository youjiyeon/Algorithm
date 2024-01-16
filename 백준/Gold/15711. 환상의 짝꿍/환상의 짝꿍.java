import java.io.*;
import java.util.*;

public class Main {
    // 소수 저장 list
    public static List<Integer> p = new ArrayList<>();
    public static boolean[] prime = new boolean[2000001];
    public static void main(String[] args)throws IOException {
        // 소수가 아니면 true
        prime[0] = prime[1] = true;
        initPrime();

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long sum = a+b;

            if (sum<4)
                sb.append("NO\n");
            // 골드바흐의 추측
            // 2보다 큰 짝수라면 두 개의 소수의 합으로 표시 가능
            else if (sum%2==0) {
                sb.append("YES\n");
            }
            else {
                if (sum-2>=2000000){
                    // 소수로 나눠지면(false) NO, 아니면 YES
                    sb.append(check(sum-2)?"YES\n":"NO\n");
                }
                else {
                    // 소수가 아니면(true) NO, 맞으면 YES
                    sb.append(prime[(int)sum-2]?"NO\n":"YES\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static void initPrime() {
        for (int i = 2; i <= 2000000; i++) {
            if (!prime[i]){
                p.add(i);
                for (int j = i*2; j <= 2000000; j+=i) {
                    prime[j] = true;
                }
            }
        }
    }

    public static boolean check(long n){
        int size = p.size();
        for (int i = 0; i < size; i++) {
            if (n%p.get(i)==0)
                return false;
        }
        return true;
    }
}