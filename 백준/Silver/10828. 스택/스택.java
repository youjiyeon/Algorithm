import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static int N;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int point = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")){
                list.add(Integer.parseInt(st.nextToken()));
                point++;
            }

            else if (str.equals("pop")){
                if (list.size()==0){
                    sb.append(-1+"\n");
                }
                else {
                    sb.append(list.get(point)+"\n");
                    list.remove(point);
                    point--;
                }
            }

            else if (str.equals("size")){
                sb.append(list.size()+"\n");
            }

            else if (str.equals("empty")){
                if (list.size()==0){
                    sb.append(1+"\n");
                }
                else {
                    sb.append(0+"\n");
                }
            }

            else if (str.equals("top")){
                if (list.size()==0){
                    sb.append(-1+"\n");
                }
                else {
                    sb.append(list.get(point)+"\n");
                }
            }
        }
        System.out.println(sb);
    }
}