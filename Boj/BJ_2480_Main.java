import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2480_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        List<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(st.nextToken()));
            max = Math.max(max, list.get(i));
        }

        int temp = list.get(0);
        int answer = max*100;
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i!=j && list.get(i)== list.get(j)){
                    answer = 1000+(list.get(i)*100);
                    break;
                }
            }
        }

        // 3개 같음
        if(temp==list.get(1) && temp==list.get(2)){
            answer= 10000+(temp*1000);
        }


        System.out.println(answer);
    }
}
