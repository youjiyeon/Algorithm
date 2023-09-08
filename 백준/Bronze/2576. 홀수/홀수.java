import java.io.*;

public class Main {
    static int sum = 0, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 7; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val%2!=0){
                sum+=val;
                min=Math.min(min,val);
            }
        }

        if (sum==0){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}