import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long CSOD = 0;
        for (int i = 2; i <= n; i++) {
            CSOD += (long) ((n-i)/i)*i;
        }
        System.out.println(CSOD%1000000);
    }
}