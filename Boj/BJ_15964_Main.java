import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15964_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());


        System.out.println(funtion(a,b));
    }

    public static long funtion(Long a, Long b) {
        return (a+b)*(a-b);
    }
}
