import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for(int i:list){
            sb.append(i+"\n");
        }
        System.out.println(sb);
    }
}
