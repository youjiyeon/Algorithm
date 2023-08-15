import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static long[] num;
    public static List<Long> two = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new long[N];

        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                two.add(num[i]+num[j]);
            }
        }

        Collections.sort(two);
        for (int i = N-1; i > 0; i--) {
            for (int j = 0; j < N; j++) {
                if(Collections.binarySearch(two, num[i]-num[j])>=0){
                    System.out.println(num[i]);
                    System.exit(0);
                }
            }
        }

    }
}
