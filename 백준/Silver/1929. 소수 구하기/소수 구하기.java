import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new boolean[1000001];
        prime[0] = prime[1] = true;
        for (int i = 2; i*i <= N; i++) {
            if(!prime[i]){
                for(int j=i*i; j<=N; j+=i) prime[j]=true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!prime[i]){
                System.out.println(i);
            }
        }
    }
}