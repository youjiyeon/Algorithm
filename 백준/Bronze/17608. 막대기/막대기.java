import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            s1.add(Integer.parseInt(br.readLine()));
        }
        while (!s1.isEmpty()){
            if(s2.isEmpty()){
                s2.add(s1.pop());
            }
            else if (s2.peek() < s1.peek()) {
                s2.add(s1.pop());
            }
            else s1.pop();
        }
        System.out.println(s2.size());
    }
}