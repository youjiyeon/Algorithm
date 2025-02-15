import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        List<Integer> agentList = new ArrayList<>();

        for (int i=1;i<6;i++){
            if(br.readLine().contains("FBI")){
                agentList.add(i);
            }
        }

        if(agentList.isEmpty()){
            System.out.print("HE GOT AWAY!");
        } else {
            StringBuilder sb = new StringBuilder();
            agentList.forEach(i->sb.append(i).append(" "));
            sb.setLength(sb.length()-1);
            System.out.print(sb);
        }
    }
}