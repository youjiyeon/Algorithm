import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] num = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i)-'0';
            if (n==6){
                num[9]++;
            }
            else
                num[n]++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            max=Math.max(max, num[i]);
        }
        int nine = num[9]/2;
        if (num[9]%2==1) nine++;
        System.out.println(Math.max(max, nine));
    }
}