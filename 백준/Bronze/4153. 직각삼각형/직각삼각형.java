import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;

            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==0&&b==0&&c==0) break;

            if(a>b && a>c){
                if(Math.pow(a, 2) == (Math.pow(b, 2))+(Math.pow(c, 2))) {
                    sb.append("right" + "\n");
                    continue;
                }
            }
            else if(b>a && b>c){
                if(Math.pow(b, 2) == (Math.pow(a, 2))+(Math.pow(c, 2))) {
                    sb.append("right" + "\n");
                    continue;
                }
            }
            else if(c>a && c>b){
                if(Math.pow(c, 2) == (Math.pow(b, 2))+(Math.pow(a, 2))) {
                    sb.append("right" + "\n");
                    continue;
                }
            }

            sb.append("wrong"+"\n");
        }
        System.out.println(sb);
    }
}