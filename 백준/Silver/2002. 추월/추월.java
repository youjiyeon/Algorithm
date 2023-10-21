import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static Map<String, Integer> map = new HashMap<>();
    public static int[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        order = new int[N];
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
            order[i] = i;
        }

        int cnt = 0;
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            order[i] = map.get(input);
        }

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(order[i] > order[j]){
                    cnt += 1;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}