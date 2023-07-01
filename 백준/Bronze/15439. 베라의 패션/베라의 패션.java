import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N, result;
    public static int[] pick;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        pick = new int[2];
        combi(0);

        System.out.println(result);
    }

    public static void combi(int cnt){
        if (cnt==2){
            if (pick[0]!=pick[1]) result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            pick[cnt] = i;
            combi(cnt+1);
        }
    }
}