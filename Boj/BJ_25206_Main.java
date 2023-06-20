import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_25206_Main {
    public static HashMap<String, Double> map = new HashMap<>(){{
        put("A+",4.5);
        put("A0",4.0);
        put("B+",3.5);
        put("B0",3.0);
        put("C+",2.5);
        put("C0",2.0);
        put("D+",1.5);
        put("D0",1.0);
        put("F",0.0);
    }};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double result = 0.0;
        double cnt = 0.0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double point = Double.parseDouble(st.nextToken());
            String val = st.nextToken();
            for (int j = 0; j < map.size(); j++) {
                if(map.containsKey(val)){
                    cnt += point;
                    result += (point)*(map.get(val));
                    continue;
                }
            }
        }
        System.out.println(String.format("%.6f",result/cnt));
    }
}
