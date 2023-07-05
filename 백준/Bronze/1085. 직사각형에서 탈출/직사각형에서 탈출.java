import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;

        int x, y, w, h;
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        min = Math.min(x,min);
        min = Math.min(y,min);
        min = Math.min(w-x,min);
        min = Math.min(h-y,min);

        System.out.println(min);
    }
}