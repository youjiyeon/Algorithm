import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2) {
                
                if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                
                else {
                    return o1.length()-o2.length();
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]+"\n");
        for (int i = 1; i < N; i++) {
            if (!str[i].equals(str[i-1])){
                sb.append(str[i]+"\n");
            }
        }
        System.out.println(sb);
    }

}