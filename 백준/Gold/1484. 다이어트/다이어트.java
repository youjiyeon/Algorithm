import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        int s = 1;
        int e = 2;
        int tmp = 0;
        while (s<e){
            tmp = (int)(Math.pow(e,2)-Math.pow(s,2));
            // G랑 일치하다면
            if (tmp==G){
                list.add(e);
                s++;
                e++;
            }
            // G보다 작다면
            else if (tmp<G){
                e++;
            }
            // G보다 크다면
            else if (tmp>G){
                s++;
            }
        }

        if (list.isEmpty()){
            System.out.println(-1);
            System.exit(0);
        }
        for (int i:list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}