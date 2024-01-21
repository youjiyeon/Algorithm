import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int aLen = Integer.parseInt(st.nextToken());
        int bLen = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        List<Integer> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aLen; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> b = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bLen; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        int aPoint = 0;
        int bPoint = 0;
        int tmpA = 0;
        int tmpB = 0;
        while (aPoint<aLen && bPoint<bLen){
            tmpA = a.get(aPoint);
            tmpB = b.get(bPoint);
            if (tmpA<tmpB){
                list.add(tmpA);
                aPoint++;
            }
            else {
                list.add(tmpB);
                bPoint++;
            }
        }

        while (aPoint<aLen){
            list.add(a.get(aPoint++));
        }
        while (bPoint<bLen){
            list.add(b.get(bPoint++));
        }
        for (int i:list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}