import java.io.*;
import java.util.*;

public class Solution {
    public static List<Integer> list;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (t<=10){
            sb.append("#").append(t).append(" ");
            list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());

            // 원본 암호문 뭉치
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            // 명령어
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                char mode = st.nextToken().charAt(0);
                switch (mode){
                    case 'I':
                        int ix = Integer.parseInt(st.nextToken());
                        int iy = Integer.parseInt(st.nextToken());
                        for (int i = ix; i < ix+iy; i++) {
                            list.add(i, Integer.parseInt(st.nextToken()));
                        }
                        break;
                    case 'D':
                        int dx = Integer.parseInt(st.nextToken());
                        int dy = Integer.parseInt(st.nextToken());
                        for (int i = 0; i < dy; i++) {
                            if(list.size()>dx)
                                list.remove(dx);
                        }
                        break;
                    case 'A':
                        int ay = Integer.parseInt(st.nextToken());
                        for (int i = 0; i < ay; i++) {
                            list.add(Integer.parseInt(st.nextToken()));
                        }
                        break;
                }
            }

            // 10개 출력 저장
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            t++;
        }
        System.out.println(sb);
    }
}