import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        prime = new boolean[1001];
        prime[0] = prime[1] = true;
        for (int i = 2; i*i <= N; i++) {
            if(!prime[i]){
                for(int j=i*i; j<=N; j+=i) prime[j]=true;
            }
        }

        boolean[] visit = new boolean[N+1];

        int c = 0;
        for (int i = 2; i <= N; i++) {
            if (!prime[i] && !visit[i]){
                c++;
                if (c==cnt){
                    System.out.println(i);
                    System.exit(0);
                }
                visit[i] = true;

                for (int j = 2; i*j <= N; j++) {
                    if (!visit[j*i]){
                        c++;
                        if (c==cnt){
                            System.out.println(j*i);
                            System.exit(0);
                        }
                        visit[j*i] = true;
                    }
                }
            }
        }
    }
}