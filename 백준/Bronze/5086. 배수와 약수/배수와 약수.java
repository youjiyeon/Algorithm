import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 종료 조건
            if(a==0 && b==0) break;

            // a가 b의 약수이다.
            if(b%a==0){
                sb.append("factor");
            }
            // a가 b의 약수이다.
            else if(a%b==0){
                sb.append("multiple");
            }
            // 둘다 아니다.
            else {
                sb.append("neither");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

}
