import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        String str = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < str.length(); i++) {
            double d = Math.pow(b,str.length()-i-1);
            char c = str.charAt(i);
            int val = c-'0';
            if(0<=val && val<=9){
                sum += val * d;
            }
            else{
                sum += (c-'A'+10) * d;
            }
        }
        System.out.println(sum);
    }
}