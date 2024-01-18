import java.io.*;
import java.util.*;

public class Solution {
    public static List<Integer> list;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int T = 1;
        while (T<=t){
            sb.append("#").append(T).append(" ");
            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            // 원본 list
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 명령어
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                char mode = st.nextToken().charAt(0);
                switch (mode) {
                    case 'I':
                        int ix = Integer.parseInt(st.nextToken());
                        int iy = Integer.parseInt(st.nextToken());
                        list.add(ix, Integer.valueOf(iy));
                        break;
                    case 'D':
                        int dx = Integer.parseInt(st.nextToken());
                        if (list.size() > dx)
                            list.remove(dx);
                        break;
                    case 'C':
                        int ax = Integer.parseInt(st.nextToken());
                        int ay = Integer.parseInt(st.nextToken());
                        list.set(ax, Integer.valueOf(ay));
                        break;
                }
            }

            // 인덱스 L에 해당하는 값 출력
            if (list.size() > l){
                sb.append(list.get(l)).append(" ");
            }
            else {
                sb.append(-1).append(" ");
            }
            sb.append("\n");
            T++;
        }
        System.out.println(sb);
    }
}
