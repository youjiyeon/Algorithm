import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_18108_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());

        System.out.println(val-543);
    }
}
