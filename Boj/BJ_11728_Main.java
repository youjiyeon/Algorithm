import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11728_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int lenA = Integer.parseInt(st.nextToken());
        int lenB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lenA; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lenB; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        int aPoint = 0;
        int bPoint = 0;

        while (aPoint<a.size() && bPoint<b.size()){
            if(a.get(aPoint) > b.get(bPoint)){
                result.add(b.get(bPoint));
                bPoint++;
            }
            else {
                result.add(a.get(aPoint));
                aPoint++;
            }
        }

        // a_point가 남아 있을경우 나머지 다 넣어준다

        while(aPoint < a.size()) {
            result.add(a.get(aPoint++));
        }

        while(bPoint <b.size()) {
            result.add(b.get(bPoint++));
        }

        for(int i=0; i<result.size(); i++) {
            sb.append(result.get(i)+" ");
        }
        System.out.println(sb);
    }
}
