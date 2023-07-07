import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            // 종료 조건
            if (n==-1)break;

            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum+=i;
                    list.add(i);
                }
            }
            if (sum==n) {
                sb.append(n+" = ");
                for (int i = 0; i<list.size(); i++) {
                    sb.append(list.get(i));
                    if(i<list.size()-1){
                        sb.append(" + ");
                    }
                }
                sb.append("\n");
            } else
                sb.append(n+" is NOT perfect.\n");
        }
        System.out.println(sb);
    }
}
