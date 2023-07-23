import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int cash = Integer.parseInt(st.nextToken());
        int cnt = 0;

        int[] num = new int[N];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        for (int i = N-1; i >= 0; i--) {
            if (cash==0){
                break;
            }
            if (cash/num[i]!=0){
                cnt += cash/num[i];
                cash %= num[i];
            }
        }
        System.out.println(cnt);
    }
}