import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] num = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum+=num[i];
        }
        System.out.println(sum/5);
        Arrays.sort(num);
        System.out.println(num[2]);
    }
}