import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_27866_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strs = str.split("");

        int num = Integer.parseInt(br.readLine());

        System.out.println(strs[num-1]);
    }
}
