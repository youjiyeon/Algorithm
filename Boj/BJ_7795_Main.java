import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_7795_Main {
    public static int lenA, lenB;
    public static List<Integer> a, b;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lenA = Integer.parseInt(st.nextToken());
            lenB = Integer.parseInt(st.nextToken());
            a = new ArrayList<>();
            b = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < lenA; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < lenB; i++) {
                b.add(Integer.parseInt(st.nextToken()));
            }
            
            Collections.sort(b);

            // 투 포인터
            twoPoint();

        }
        System.out.println(sb);
    }

    private static void twoPoint() {
        int cnt = 0;
        for(int i=0;i<lenA;i++) {
            for(int j=lenB-1;j>=0;j--) {
                if(a.get(i)>b.get(j)) {
                    cnt+=j+1;
                    break;
                }
            }
        }

        sb.append(cnt+" ");
    }
}
// 왜 안될까
/*        int aPoint = 0;
        int bPoint = 0;
        int cnt = 0;

        while (aPoint<lenA){
            //if(aPoint>=lenA) break;

            if(a.get(aPoint)>b.get(bPoint)){
                //System.out.println(aPoint +" "+ bPoint);
                cnt+=(lenB-bPoint);
                aPoint++;
                bPoint = 0;
            }
            else {
                bPoint++;
            }
            if(bPoint>=lenB){
                break;

                //aPoint++;
                //bPoint = 0;
            }
        }*/
