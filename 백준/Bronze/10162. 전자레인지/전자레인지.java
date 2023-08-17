import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int[] num = {300, 60, 10};
    public static int[] n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        n = new int[3];
        for (int i = 0; i < 3; i++) {
            if (N/num[i]!=0){
                n[i] += N/num[i];
                N%=num[i];
            }
        }

        if (N!=0){
            System.out.println(-1);
        }
        else {
            for (int i = 0; i < 3; i++) {
                System.out.print(n[i]+" ");
            }
        }
    }
}
