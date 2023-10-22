import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] num = str.split(",");
            int sum = 0;
            sum += num[0].charAt(0)-'0';
            sum += num[1].charAt(0)-'0';
            
            sb.append(sum).append("\n");
        }
        
        System.out.println(sb);
    }
}